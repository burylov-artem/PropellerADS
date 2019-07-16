package PropellerADS;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/PropellerADS/features/"},
        tags = {"@youtube_registration"},
        glue = "PropellerADS",
        format = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"},
        plugin = {"json:target/cucumber.json"}
)

public class Run {

    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public static void stop() {
        driver.close();
    }
}
