package PropellerADS.search;

import PropellerADS.Run;
import PropellerADS.registration.Registration_selectors;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class Search_methods {

    WebDriver driver = Run.getDriver();

    Search_selectors selectors = new Search_selectors();

    @When("set text in search \"(.*)\"")
    public void setTextInSearch(String text) {
        driver.findElement(By.xpath(selectors.inputSearch)).sendKeys(text);
    }

    @When("press button search")
    public void pressButtonSearch() {
        driver.findElement(By.xpath(selectors.buttonSearch)).click();
    }

    @Then("We check the correctness of the displayed results on request \"(.*)\"")
    public void considerHowManySimilarResults(String request) {
        String[] title = new String[1000];
        int numberOfCoincidences = 0;
        request = request.toLowerCase();

        driver.findElement(By.xpath(selectors.elementPreview));

//      Считаем кол-во отобразившихся видео на странице
        int countAllResults = driver.findElements(By.xpath(selectors.elementPreview)).size();
//      Получаем заголовок видео и проверяем содержится ли в нем наш поисковый запрос
        for (int i = 1; i <= countAllResults; i++) {
            title[i] = driver.findElement(By.xpath(String.format(selectors.titleVideo, i))).getText();
            title[i] = title[i].toLowerCase();
            if (title[i].contains(request)) {
                numberOfCoincidences++;
            } else {
                System.out.println("Название видео не соответствует искомому запросу - " + "[" + i + "] " + title[i]);
            }
        }

        System.out.println("Количество всех видео " + countAllResults + ", искомый заголовок из них содержит " + numberOfCoincidences);

//      Вычисляем процент релевантных видео
        int percentСorrect = (numberOfCoincidences*100)/countAllResults;

        System.out.println("Процент релевантных видео составляет - " + percentСorrect);

//      Если процент релевантных видео больше 85, проверка считается пройденной
        if (percentСorrect>=85) {
            System.out.println("+ Проверка пройдена +");
        } else {
            System.out.println("- Проверка провалена -");
            fail("Проверка не пройдена");
        }


    }

    @When("upload more videos")
    public void uploadMoreVideos() throws InterruptedException {
        driver.findElement(By.xpath(selectors.buttonSearch)).sendKeys(Keys.END);
        Thread.sleep(1000);
        System.out.println("- Загрузили на страницу ещё видео -");
    }

    @Then("text message on error \"(.*)\"")
    public void textMssageOnError(String text)  {
        driver.findElement(By.xpath(String.format(selectors.textOnPageError, text)));
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
