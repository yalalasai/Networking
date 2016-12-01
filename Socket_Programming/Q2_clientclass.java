import java.net.*;
import java.io.*;

public class Q2_clientclass
{
    public static void main(String args [])
    {
        try
        {
            Socket socketvar = new Socket("localhost",8089);

            OutputStream outvar = socketvar.getOutputStream();
            DataOutputStream dataoutvar = new DataOutputStream(outvar);
            InputStream invar = socketvar.getInputStream();
            DataInputStream datainvar = new DataInputStream(invar);

            int i = 10;
            while(i > 0)
            {
                dataoutvar.writeUTF("Hello from client !!");
                String Msg = datainvar.readUTF();
                System.out.println("Server says : " + Msg + "\n");
                i--;
            }
            socketvar.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException : " + e.getMessage());
        }
    }
}