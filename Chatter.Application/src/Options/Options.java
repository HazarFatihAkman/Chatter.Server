package Options;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Options<T>
{
    public String Prefix;
    
    private T _singletonInstance;
    private final Class<T> tClass;

    public Options(String prefix)
    {
        this.Prefix = prefix;
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        tClass = (Class) pt.getActualTypeArguments()[0];
    }
    
    public T getInstance()
    {
        if (_singletonInstance == null)
        {
            return null;
        }
        
        return _singletonInstance;
    }

    public void createInstance() throws InstantiationException, IllegalAccessException
    {
        if (_singletonInstance == null)
        {
            _singletonInstance = tClass.newInstance();
        }
    }
}
