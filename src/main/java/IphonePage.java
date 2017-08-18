import org.apache.xpath.SourceTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IphonePage {

    @FindBy(xpath = ".//div[contains(@id,'product_offers_container')]//li/div[3]/p[1]/a")
    private List<WebElement> shopList;

    @FindBy(xpath = ".//*[@id='prod_row_166766615']/div[1]/div/div[1]/div/p[1]/span[3]/b/span")
    private WebElement availableStores;

    @FindBy(xpath = ".//div[contains(@id,'product_offers_container')]//li//div[2]//div[3]/p[1]/a")
    private List<WebElement> prices;

    @FindBy(xpath = ".//div[contains(@class,'tab-content')]//ul/li//div[2]/p[1]/a")
    private List<WebElement> storeNames;

    private WebDriver webDriver;

    public IphonePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getTotalAvailableStoresNumber() {
        String totalAvailableStoresNumber = availableStores.getText();
        return totalAvailableStoresNumber;
    }

    public Integer getShopNumber() {
        Integer shopNumber = shopList.size();
        return shopNumber;
    }

    public String getSmallestPrice() {
        List<Double> priceList = new ArrayList<Double>();
        for (int i = 0; i < prices.size(); i++) {
            String p = prices.get(i).getText();
            Double p1 = Double.parseDouble(p.replace(" RON", "").replace(".", "").replace(",", "."));
            priceList.add(i, p1);
        }
        int minIndex = priceList.indexOf(Collections.min(priceList));
        String storeName = storeNames.get(minIndex).getAttribute("title");
        return "Cheapest phone was found at " + storeName + " for " + prices.get(minIndex).getText();
    }

    public String getHighestPrice() {
        List<Double> priceList = new ArrayList<Double>();
        for (int i = 0; i < prices.size(); i++) {
            String p = prices.get(i).getText();
            Double p1 = Double.parseDouble(p.replace(" RON", "").replace(".", "").replace(",", "."));
            priceList.add(i, p1);
        }
        int maxIndex = priceList.indexOf(Collections.max(priceList));
        String storeName = storeNames.get(maxIndex).getAttribute("title");
        return "The most expensive phone was found at " + storeName + " for " + prices.get(maxIndex).getText();
    }
}
