package PropellerADS.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PropellerADS.Run;
import cucumber.api.java.en.*;

public class Registration_methods {

    WebDriver driver = Run.getDriver();

    Registration_selectors selectors = new Registration_selectors();

    @Given("open page \"(.*)\"")
    public void setUrl(String url) {
        driver.navigate().to(url);
    }

    @When("press button to sign in")
    public void pressButtonToSignIn() {
        driver.findElement(By.xpath(selectors.buttonSignIn)).click();
    }

    @When("press button create account")
    public void pressButtonCreateAccount() {
        driver.findElement(By.xpath(selectors.buttonCreateAccount)).click();
    }

    @When("press button for myself")
    public void pressButtonForMyself() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(selectors.buttonForMyself)).click();
    }

    @When("set text \"(.*)\" in input text \"(.*)\"")
    public void setTextInInputText(String text, String nameInput) {
        driver.findElement(By.xpath(String.format(selectors.inputForText, nameInput))).sendKeys(text);
    }

    @When("in input password \"(.*)\" set text \"(.*)\"")
    public void setTextInInputPassword(String name, String text) {
        driver.findElement(By.xpath(String.format(selectors.inputForPassword, name))).sendKeys(text);
    }

    @Then("text error \"(.*)\"")
    public void textError(String text) {
        driver.findElement(By.xpath(String.format(selectors.textError, text)));
    }

    @Then("part text error \"(.*)\"")
    public void partTextError(String text) {
        driver.findElement(By.xpath(String.format(selectors.partTextError, text)));
    }

    @When("press button further")
    public void pressButtonFurther() {
        driver.findElement(By.xpath(selectors.buttonFurther)).click();
    }

    @When("waiting")
    public void waiting() throws InterruptedException {
        Thread.sleep(1000);
    }

    @When("check users auth \"(.*)\"")
    public void checkUserAuth(String email) {
        driver.findElement(By.xpath(selectors.avatarAuthUser)).click();
        driver.findElement(By.xpath(String.format(selectors.loginEmail, email)));
        driver.findElement(By.xpath(selectors.avatarAuthUser)).click();
    }


    @Then("check text at head page confirmed email \"(.*)\"")
    public void checkTextAtHeadPageConfirmedEmail(String textInHead) {
        driver.findElement(By.xpath(String.format(selectors.headPageConfirmedEmail, textInHead)));
    }

    @Then("check text page confirmed email \"(.*)\"")
    public void checkTextPageConfirmedEmail(String text) {
        driver.findElement(By.xpath(String.format(selectors.textPageConfirmedEmail, text)));
    }

    @When("set email/phone in field login \"(.*)\"")
    public void setEmailPhoneInFieldLogin(String text) {
        driver.findElement(By.xpath(selectors.inputTypeEmailForAuth)).sendKeys(text);
    }



    public boolean elementIsVisible(String xpath) {
        WebDriverWait wait = new WebDriverWait(Run.getDriver(), 1, 500);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }




}
