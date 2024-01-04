package Options;

public class DbOptions extends Options<DbOptions>
{
    //TODO : bind json data to properties automatically
    private String[] _keys;
    private String _sqlLite;
    private static DbOptions _singletonInstance;


    public DbOptions()
    {
        super("DbOptions");
    }

    //Getters    
    public String getSqlLite()
    {
        return this._sqlLite;
    }

    @Override
    public DbOptions getInstance()
    {
        if (_singletonInstance == null)
        {
            _singletonInstance = new DbOptions();
        }

        return _singletonInstance;
    }
}
