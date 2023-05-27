package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private final SelenideElement profileButton = $("button[data-qa='mainmenu_applicantProfile']");
    private final SelenideElement username = $("a[data-qa='mainmenu_applicantInfo']");
    private final SelenideElement myResumesButton = $("a[data-qa='mainmenu_myResumes']");

    public String getUsername() {
        profileButton.click();
        username.shouldBe(Condition.visible);
        return username.innerText();
    }

    public ResumePage openMyResumes() {
        myResumesButton.click();
        return page(ResumePage.class);
    }
}