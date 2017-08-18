import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelephonePage {
    @FindBy(xpath = ".//*[@id='main_products_container']/ul/li[1]/div[2]//div[2]/a")
    private WebElement phonePrice;

    private WebDriver webDriver;

    public TelephonePage(WebDriver driver) {
        this.webDriver = driver;
    }

    @FindBy(xpath = ".//*[@id='main_products_container']/ul/li[1]/div[3]/p[1]/a")
    private WebElement selectIphone;

    public IphonePage goToIPhones() {
        selectIphone.click();
        IphonePage iphonePage = PageFactory.initElements(webDriver, IphonePage.class);
        return iphonePage;
    }

    public String getPrice() {
        return String.valueOf(phonePrice.getText());
    }
}
