import java.net.*;
import java.io.*;

public class Q2_serverclass
{
    public static void main(String args [])
    {
        try
        {
            ServerSocket ssvar = new ServerSocket(8089);
            Socket server = ssvar.accept();

            InputStream invar = server.getInputStream();
            DataInputStream datainvar = new DataInputStream(invar);
            OutputStream outvar = server.getOutputStream();
            DataOutputStream dataoutvar = new DataOutputStream(outvar);

            int i = 10;
            while(i > 0)
            {
                String Msg = datainvar.readUTF();
                System.out.println("client is saying : " + Msg + "\n");
                dataoutvar.writeUTF("Hello from the server !");
                i--;
            }
            server.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }

    }
}