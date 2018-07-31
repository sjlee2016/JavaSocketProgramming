package muc;
import java.io.*;
import java.net.*;


public class ServerWorker extends Thread {

	private final Socket clientSocket;
	
	public ServerWorker(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
		
	}
	public void run()
	{
		try {
			handleClientSocket();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void handleClientSocket() throws IOException, InterruptedException {
		OutputStream outputStream = clientSocket.getOutputStream();
		InputStream inputStream = clientSocket.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		
		while((line=reader.readLine())!=null)
		{
			String msg[] = line.split(" ", 60);
			String cmd = msg[0];
			if(cmd.equals("Bye"))
			{
				break;
			}else if(cmd.equals("login"))
			{
				try
				{
				String id = msg[1];
				String password = msg[2];
				outputStream.write((id+password).getBytes());
				}
				catch(ArrayIndexOutOfBoundsException exception)
				{

					outputStream.write(("Do you mean login ID Password? ").getBytes());
					exception.getStackTrace(); 
				}
			}else if(cmd.equals("signin"))
			{
				try
				{
				String id = msg[1];
				String password = msg[2];
				outputStream.write((id+password).getBytes());
				}
				catch(ArrayIndexOutOfBoundsException exception)
				{

					outputStream.write(("Do you mean signin ID Password? ").getBytes());
					exception.getStackTrace(); 
				}
				
			}else
			{
				outputStream.write(line.getBytes());
				
			}
				
			// else echo back to the client
			
		}
		clientSocket.close();
		
	}
}

