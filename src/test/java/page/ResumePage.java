package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResumePage {

    private final SelenideElement header = $("h1[data-qa='bloko-header-1']");
    private final ElementsCollection resumes = $$("div[data-qa='resume']");

    public ResumePage() {
        header.shouldBe(visible);
    }

    public String getResumeTitle() {
        return resumes.first()
                .$("h3 [data-qa='resume-title']")
                .innerText();
    }
}