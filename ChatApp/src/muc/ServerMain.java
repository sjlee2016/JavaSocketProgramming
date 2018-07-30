package muc;


import java.net.ServerSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8820;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true)
			{
				System.out.println("About to accept client connection..");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Accepted connection from" + clientSocket);
				OutputStream outputStream = clientSocket.getOutputStream();
				outputStream.write("Hello World\n".getBytes());
				clientSocket.close(); 
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
