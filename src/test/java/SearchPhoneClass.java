import org.junit.Test;

public class SearchPhoneClass extends TestClass{
@Test
    public void firstTest(){
    CategoriesPage categoriesPage = homePage.searchPhone("iphone");

    TelephonePage telephonePage = categoriesPage.goToPhones();
    System.out.println("Price: " + telephonePage.getPrice());

    IphonePage iphonePage = telephonePage.goToIPhones();
    System.out.println("The number of available stores per page is " + iphonePage.getShopNumber());
    System.out.println("The total number of available stores is " + iphonePage.getTotalAvailableStoresNumber());
    System.out.println(iphonePage.getSmallestPrice());
    System.out.println(iphonePage.getHighestPrice());
}
}
