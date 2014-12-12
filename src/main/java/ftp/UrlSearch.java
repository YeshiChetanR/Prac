package ftp;

import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.eclipse.osgi.util.TextProcessor;



public class UrlSearch {
	static URL url ;
	public static String main(String[] args) throws IOException {
		url = new URL("http://50.50.50.224:8080/computer/api/xml?xpath=/computerSet/busyExecutors/text()");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();	
		
		System.out.println(conn.getContentType() );
		System.out.println(conn.getResponseMessage() );
		
		InputStream in = conn.getInputStream();
		String encoding = conn.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		System.out.println(body);
		if(body.equalsIgnoreCase("0")){
			System.out.println("Hello");
		}
		return body;
	
	}
	
}

//http://50.50.50.224:8080/computer/api/xml?xpath=/computerSet/busyExecutors/text()