package Options;

import java.io.IOException;

public class DbOptions extends Options<DbOptions> implements IDbOptions
{
    //TODO : bind json data to properties automatically
    private String _sqlLite;
    private IOptionReader optionReader;

    public DbOptions() throws InstantiationException, IllegalAccessException, IOException
    {
        super("DbOptions");
        _sqlLite = optionReader.readKey(Prefix, "SqlLite");
    }

    //Getters
    public String getSqlLite()
    {
        return this._sqlLite;
    }
}
