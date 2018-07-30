package muc;


import java.net.ServerSocket;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8820
				;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true)
			{
				System.out.println("About to accept client connection..");
				Socket clientSocket = serverSocket.accept();
				// accept incoming connection
				System.out.println("Accepted connection from" + clientSocket);
				ServerWorker worker = new ServerWorker(clientSocket);
				// creates serverWorker which is a thread that communicates with clients
				
				worker.start();
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	

}
