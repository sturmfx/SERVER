
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Connection extends Thread
{
    private int limit = 10;

    private Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    public Connection(Socket socket) throws IOException
    {
        this.socket = socket;
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        start();
    }
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                Integer number_of_person;
                ArrayList<String> person_list = new ArrayList<>();

                number_of_person = (Integer) ois.readObject();

                if(number_of_person > limit)
                {
                    number_of_person = limit;
                }

                for(int i = 0; i < number_of_person; i++)
                {
                    person_list.add(Person.getPerson());
                }

                oos.writeObject(person_list);
            }

        } catch (IOException | ClassNotFoundException e)
        {
        }
    }



}
