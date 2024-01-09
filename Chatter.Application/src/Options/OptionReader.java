package Options;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class OptionReader implements IOptionReader
{
    //TODO : binding method
    private String _appSettingsPath;
    private static OptionReader _singletonInstance;

    public OptionReader()
    {
        findAppSettings(new File(System.getProperty("user.dir")));
        createInstance();
    }

    //Getters
    public OptionReader getInstance()
    {
        return _singletonInstance;
    }

    public void createInstance()
    {
        if (_singletonInstance == null)
        {
            _singletonInstance = new OptionReader();
        }
    }

    public String getAppSettingsPath()
    {
        return this._appSettingsPath;
    }

    public String readKey(String prefix, String key) throws IOException
    {
        String value = new String();
        File file = new File(_appSettingsPath);

        try
        {
            String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
            JSONObject jsonContent = new JSONObject(content);
            JSONObject jsonObject = jsonContent.getJSONObject(prefix);
            value = jsonObject.getString(key);
            return value;
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    private void findAppSettings(File dir)
    {
        File[] list = dir.listFiles();

        for(File file : list)
        {
            if (file.isDirectory())
            {
                findAppSettings(file);
            }
            else if(file.getName().contains("appsettings.json"))
            {
                this._appSettingsPath = file.getAbsolutePath();
                break;
            }
        }
    }
}
