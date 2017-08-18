import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "autocomplete_prod")
    private WebElement searchBox;

    @FindBy(className = "btn")
    private WebElement searchButton;

    private WebDriver webDriver;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public CategoriesPage searchPhone(String phoneName) {
        searchBox.sendKeys(phoneName);
        searchButton.click();
        CategoriesPage categoriesPage = PageFactory.initElements(webDriver, CategoriesPage.class);
        categoriesPage.waitUntilCompleteLoad();
        return categoriesPage;
    }
}
