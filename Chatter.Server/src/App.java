import Options.DbOptions;
import Options.IDbOptions;

public class App {
    public static void main(String[] args) throws Exception
    {
        try
        {
            IDbOptions dbOptions = new DbOptions();

            System.out.println(dbOptions.hashCode());

            var test = new Test();
            System.out.println(test.getTest());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}