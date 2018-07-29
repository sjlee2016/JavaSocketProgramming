import java.io.*;
import java.util.*;
import java.net.*;

public class EchoServer
{
    public static void main (String [] args)
    {

        try
        {                            // port number .  try to choose anything above 1000  -> not reserved 
            ServerSocket s = new ServerSocket(8189);
            boolean over = false;
            while(!over)
            {
                Socket incoming = s.accept();
                try
                {
                    InputStream inStream = incoming.getInputStream(); // listener
                    OutputStream outStream = incoming.getOutputStream(); // speaker
                    Scanner in = new Scanner(inStream);
                    PrintWriter out = new PrintWriter(outStream, true); // flush . gather all data and send it at once 
                    boolean done = false;
                    while (!done && in.hasNextLine())
                    {
                        String lineIn = in.nextLine();
                        System.out.println(lineIn.trim());
                        if(lineIn.trim().equals("BYE"))
                            done = true;
                    }
                 }
         catch(Exception exc1)
        {
            exc1.printStackTrace();
       }
        }
        }
        catch(Exception exc2)
      {
         exc2.printStackTrace();
      }
        }
    }
    
