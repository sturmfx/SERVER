
import java.io.Serializable;
import java.util.Random;

public class Person implements Serializable
{
    static Random random = new Random();

    static String[] names = {"Ivan", "Olga", "Susan", "Li", "John", "Emma", "Ava", "Sofia", "Victoria", "James"};
    static String[] second_names = {"Smith", "Johnson", "Jones", "Anderson", "Gonzalez", "Thomas", "Perry", "Clark", "Lewis", "Wilson"};

    String name;
    String second_name;
    String email;

    public Person()
    {
        this.name = names[random.nextInt(names.length)];
        this.second_name = second_names[random.nextInt(second_names.length)];
        this.email = this.name + "." + this.second_name + random.nextInt(1000) + "@gmail.com";
    }

    public static String getPerson()
    {
        Person p = new Person();
        return p.toString();
    }
    @Override
    public String toString()
    {
        String result = "";
        result = "NAME: " + this.name + ", SECOND NAME: " + this.second_name + ", EMAIL: " + this.email  + ".";
        return result;
    }
}
