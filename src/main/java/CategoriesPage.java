import com.gargoylesoftware.htmlunit.WebAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {
    @FindBy(xpath = ".//*[@id='main_col']/div/ul[1]/li[7]/a")
    private WebElement selectTelephones;

    private WebDriver webDriver;

    public CategoriesPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public TelephonePage goToPhones() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectTelephones.click();

        TelephonePage telephonePage = PageFactory.initElements(webDriver, TelephonePage.class);
        return telephonePage;
    }

    public void waitUntilCompleteLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10000);
    }
}
