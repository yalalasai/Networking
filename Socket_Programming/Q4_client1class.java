import java.net.*;
import java.io.*;

public class client1class
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
                System.out.print("Client1: ");
                Msg = System.console().readLine();
                if (Msg.equals("end"))
                    break;
                dataoutvar.writeUTF(Msg);

                Msg = datainvar.readUTF();

                System.out.println("Client2: " + Msg + "\n");
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