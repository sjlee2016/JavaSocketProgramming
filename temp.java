
import java.io.*;
import java.net.*;
import java.util.*;
public class client
{
  public static void main(String [] args)
  {
  try
  {
         Socket s = new Socket("192.168.2.122",5092);
         try
         {
       InputStream inStream = s.getInputStream();
      Scanner in = new Scanner(inStream);
    while(in.hasNextLine())
   {
  String line = in.nextLine();
  System.out.println(line);
} }
finally
{
s.close();
} 
}
  catch(IOException ioexc)
  {
         ioexc.printStackTrace();
  }
  }  //end public
}  //end class
