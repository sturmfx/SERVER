
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Main
{
    public static final int port = 7777;
    public static LinkedList<Connection> connection_list = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        ServerSocket server = new ServerSocket(port);
        try
        {
            while (true)
            {
                Socket socket = server.accept();
                try
                {
                    connection_list.add(new Connection(socket));
                }
                catch (IOException e)
                {
                    socket.close();
                }
            }
        }
        finally
        {
            server.close();
        }
    }
}
