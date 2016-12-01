import java.net.*;
import java.io.*;

public class Q1_clientcode
{
    public static void main(String args [])
    {
        try
        {
            Socket socketvar = new Socket("localhost",8070);
            
            OutputStream outvar = socketvar.getOutputStream();
            DataOutputStream dataoutvar = new DataOutputStream(outvar);
            dataoutvar.writeUTF("Hello from client");

            InputStream invar = socketvar.getInputStream();
            DataInputStream datainvar = new DataInputStream(invar);
            String Msg = datainvar.readUTF();
            System.out.println("Server says : " + Msg + "\n");

            socketvar.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
       /* catch(UnknownHostException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }*/
    }
}