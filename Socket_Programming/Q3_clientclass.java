import java.net.*;
import java.io.*;

public class Q3_clientclass
{
    public static void main(String args [])
    {
        try
        {
            Socket socketvar = new Socket("localhost",8069);

            OutputStream outvar = socketvar.getOutputStream();
            DataOutputStream dataoutvar = new DataOutputStream(outvar);
            InputStream invar = socketvar.getInputStream();
            DataInputStream datainvar = new DataInputStream(invar);
            
            String Msg = " ";
            while(true)
            {
                System.out.print("Client : ");
                Msg = System.console().readLine();
                if(Msg.equals("END"))
                    break;
                dataoutvar.writeUTF(Msg);
                System.out.print("Server : ");
                Msg = datainvar.readUTF();
                System.out.println(Msg);
            }
            socketvar.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}