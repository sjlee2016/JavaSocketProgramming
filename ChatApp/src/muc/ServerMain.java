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
				System.out.println("Accepted connection from" + clientSocket);
				Thread t = new Thread() { // create a new thread for each new connection
					public void run(){
						try {
							handleClientSocket(clientSocket);
							
						}catch(IOException e)
						{
							e.printStackTrace();
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				};
				}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void handleClientSocket(Socket clientSocket) throws IOException, InterruptedException {
		OutputStream outputStream = clientSocket.getOutputStream();
		for(int i = 0 ; i<10; i++)
		{
			outputStream.write(("Time now is " + new Date() + "\n").getBytes());
			Thread.sleep(1000);
		}
		clientSocket.close();
	}

}
