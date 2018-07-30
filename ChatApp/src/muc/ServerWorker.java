package muc;
import java.io.*;
import java.net.Socket;
import java.util.Date;


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
			if("quit".equalsIgnoreCase(line))  // stop connection when received "quit"
			{
				break;
			}
			// else echo back to the client
			
			String msg = "You typed : " + line + "\n";
			outputStream.write(msg.getBytes());
		}
		clientSocket.close();
	}

}
