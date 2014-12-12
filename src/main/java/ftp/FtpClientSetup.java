package ftp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpClientSetup {
	
	public static void main(String[] args) throws SocketException, IOException {
		FTPClient ftpClient=new FTPClient();
		String server="10.10.10.15";
		int port=50;
		
		  ftpClient.connect(server, port);
		  
         ftpClient.login("qateam","atmecs@123");
          ftpClient.enterLocalPassiveMode();

          ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
          
          File f=new File("C:\\Users\\chetan.yeshi\\Desktop\\aaa.html");
          String localFile="aa.html";
          
          InputStream inputStream=new FileInputStream(f);
          
          boolean done=ftpClient.storeFile(localFile,inputStream);
          System.out.println("Done:"+done);
          inputStream.close();
          if (done) {
              System.out.println("The first file is uploaded successfully.");
          }
          
          FTPFile[] files = ftpClient.listFiles();
           for (FTPFile ftpFile : files) {
          
             if (ftpFile.getType() == FTPFile.FILE_TYPE) {
          
            System.out.println("File: " + ftpFile.getName() +
          
           
          
              "  size-> " + FileUtils.byteCountToDisplaySize(
         
           
          
              ftpFile.getSize()));
          
              }
          
          }
           File downloadFile1 = new File("C:\\Users\\chetan.yeshi\\Desktop\\Jenkins\\log");
           String remoteFile1="log";
           OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
           boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
           outputStream1.close();

           if (success) {
               System.out.println("File #1 has been downloaded successfully.");
               
           }
           
    
	}

}
