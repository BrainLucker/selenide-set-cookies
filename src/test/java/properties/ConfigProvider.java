package properties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String TEST_COOKIE = readConfig().getString("usersParams.test.cookieValue");
    String TEST_USERNAME = readConfig().getString("usersParams.test.userName");
    String TEST_RESUME_TITLE = readConfig().getString("usersParams.test.resumeTitle");
}