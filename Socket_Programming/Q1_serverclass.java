import java.net.*;
import java.io.*;

public class Q1_serverclass
{
    public static void main(String args [])
    {
        try
        {
            ServerSocket ssvar = new ServerSocket(8070);
            Socket server = ssvar.accept();

            InputStream invar = server.getInputStream();
            DataInputStream datainvar = new DataInputStream(invar);
            String Msg = datainvar.readUTF();
            System.out.println("Client says : " + Msg + "\n");

            OutputStream outvar = server.getOutputStream();
            DataOutputStream dataoutvar = new DataOutputStream(outvar);
            Msg = "Hello from server !";
            dataoutvar.writeUTF(Msg);

            server.close();   
        }

        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
