package ave4testing.pageobjects;

import ave4testing.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponent {

    private WebDriver driver;

    @FindBy(css = ".hero-primary")
    WebElement confirmationMessage;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String verifyConfirmationMessage()
    {
        CheckoutPage cp = new CheckoutPage(driver);
        cp.submitOrder();
        return confirmationMessage.getText();

    }








}
