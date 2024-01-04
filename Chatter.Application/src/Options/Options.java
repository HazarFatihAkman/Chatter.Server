package Options;

public abstract class Options<T>
{
    public String Prefix;

    public Options(String prefix)
    {
        this.Prefix = prefix;
    }
    
    public T getInstance()
    {
        return null;
    }
}
