package ave4testing.pageobjects;

import ave4testing.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(css = ".btnn.action__submit.ng-star-inserted")
    WebElement submit;
    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

     @FindBy(xpath = "//span[@class='ng-star-inserted']")
     WebElement selectCountry;



    By results = By.cssSelector(".ta-results");


   public void SelectCountry(String countryName)
   {
       Actions a = new Actions(driver);
       a.sendKeys(country, countryName).build().perform();
       waitForElementToAppear(results);
       selectCountry.click();
   }

   public ConfirmationPage submitOrder()
   {
       submit.click();
       return new ConfirmationPage(driver);

   }





}