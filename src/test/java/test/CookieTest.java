package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import core.BaseSelenideTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.MainPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static properties.ConfigProvider.*;

public class CookieTest extends BaseSelenideTest {

    @BeforeEach
    public void setUpExtension() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("src/test/resources/modheader.crx"));
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        addCookie();
    }

    private void addCookie() {
        Selenide.open("https://www.google.com/");
        Selenide.closeWindow(); // закрытие лишней вкладки
        switchTo().window(0);
        Selenide.open("chrome-extension://idgpnmonknjnojddfkpgkljpfnnfcklj/app.html");
        $("input[name='header-name']").sendKeys("cookie");
        $("input[name='header-value']").sendKeys(TEST_COOKIE);
        $("input[name='header-name']").click();
    }

    public MainPage openMainPage() {
        return open(URL, MainPage.class);
    }

    @Test
    public void shouldShowUsername() {
        String actualUsername = openMainPage().getUsername();

        Assertions.assertEquals(TEST_USERNAME, actualUsername);
    }

    @Test
    public void shouldShowResume() {
        String actualTitle = openMainPage()
                .openMyResumes()
                .getResumeTitle();

        Assertions.assertEquals(TEST_RESUME_TITLE, actualTitle);
    }
}