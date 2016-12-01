import java.net.*;
import java.io.*;

public class Q3_serverclass
{
    public static void main(String args [])
    {
        try
        {
            ServerSocket ssvar = new ServerSocket(8069);
            Socket server = ssvar.accept();

            InputStream invar = server.getInputStream();
            DataInputStream datainvar = new DataInputStream(invar);
            OutputStream outvar = server.getOutputStream();
            DataOutputStream dataoutvar = new DataOutputStream(outvar);
            String Msg = " ";

            while(true)
            {
                Msg = datainvar.readUTF();
                System.out.println("Client : ");
                System.out.println(Msg);
                System.out.println("Server : ");
                Msg = System.console().readLine();
                if(Msg.equals("END"))
                    break;
                dataoutvar.writeUTF(Msg);
            }
            server.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}