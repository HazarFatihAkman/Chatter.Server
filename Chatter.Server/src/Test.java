import Options.IDbOptions;

public class Test
{
    private IDbOptions dbOptions;

    public String getTest()
    {
        System.out.println(dbOptions.hashCode());
        return dbOptions.getSqlLite();
    }
}
