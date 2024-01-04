import Options.DbOptions;
import Options.OptionReader;

public class App {
    public static void main(String[] args) throws Exception
    {
        var optionReader = OptionReader.getInstance();
        
        var dbOptions = new DbOptions();

        optionReader.readKey(dbOptions.Prefix, "SqlLite");
    }
}