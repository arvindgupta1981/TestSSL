import java.io.InputStream;
import java.io.OutputStream;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/*
Install a certificate:- 
keytool -import -alias vertex09 -file mycert.cer -keystore cacerts 


List All certificate
C:\Program Files\Java\jdk1.8.0_73\jre\lib\security>keytool -list -keystore cacer
ts -rfc >> d:\testcert.txt

Remove a certificate:-
C:\Program Files\Java\jdk1.8.0_73\jre\lib\security>keytool -delete -alias vertex
09 -keystore cacerts


 */


public class SSLTest {	
	 public static void main(String[] args) {
			
			try {
				SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
				SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("jeld-wen.ondemand.vertexinc.com", 443);

				InputStream in = sslsocket.getInputStream();
				OutputStream out = sslsocket.getOutputStream();

				// Write a test byte to get a reaction :)
				out.write(1);

				while (in.available() > 0) {
					System.out.print(in.read());
				}
				System.out.println("Successfully connected");

			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
}
