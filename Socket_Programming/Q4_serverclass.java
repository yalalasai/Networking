import java.net.*;
import java.io.*;

public class serverCode
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket ssvar = new ServerSocket(443);
            System.out.println("Server listing to port 443...");
            
            Socket server1 = ssvar.accept();
            Socket server2 = ssvar.accept();

            InputStream invar1 = server1.getInputStream();
            DataInputStream datainvar1 = new DataInputStream(invar1);
            OutputStream outvar1 = server1.getOutputStream();
            DataOutputStream dataoutvar1 = new DataOutputStream(outvar1);
            InputStream invar2 = server2.getInputStream();
            DataInputStream datainvar2 = new DataInputStream(invar2);
            OutputStream outvar2 = server2.getOutputStream();
            DataOutputStream dataoutvar2 = new DataOutputStream(outvar2);
        
            String Msg = "";
            while(true)
            {
                Msg = datainvar1.readUTF();
                if (Msg.equals("end"))
                    break;
                dataoutvar2.writeUTF(Msg);
                
                Msg = datainvar2.readUTF();
                if (Msg.equals("end"))
                    break;
                dataoutvar1.writeUTF(Msg);
            }
            
            server1.close();
            server2.close();
        }

        catch(IOException e)
        {
            System.out.println("IO Exception: " + e.getMessage());
        }
    } 
}