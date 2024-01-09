package Options;

import java.io.IOException;

public interface IOptionReader
{
    OptionReader getInstance();
    String getAppSettingsPath();
    String readKey(String prefix, String key) throws IOException;
}
