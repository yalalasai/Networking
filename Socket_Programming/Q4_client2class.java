import java.net.*;
import java.io.*;

public class clientCode2
{
    public static void main(String args[])
    {
        try
        {

            InetAddress addr = InetAddress.getByName("172.19.16.66");
            Socket socketvar = new Socket(addr, 443);
            
            OutputStream outvar = socketvar.getOutputStream();
            DataOutputStream dataoutvar = new DataOutputStream(outvar);
            InputStream invar = socketvar.getInputStream();
            DataInputStream datainvar = new DataInputStream(invar);
            
            String Msg = "";
            while (true)
            {
                Msg = datainvar.readUTF();

                System.out.println("Client1: " + Msg + "\n");
            
                System.out.print("Client2: ");
                Msg = System.console().readLine();
                if (Msg.equals("end"))
                    break;
                dataoutvar.writeUTF(Msg);
            }
            
            socketvar.close(); 
        }

        catch(UnknownHostException e)
        {
            System.out.println("UnknownHost Exception: " + e.getMessage());
        }

        catch(IOException e)
        {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}