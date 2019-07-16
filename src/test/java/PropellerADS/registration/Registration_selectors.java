package PropellerADS.registration;

public class Registration_selectors {

    public String
            buttonSignIn = "//div[@id='buttons']//yt-formatted-string[text()='Войти']",
            buttonCreateAccount = "//span[text()='Создать аккаунт']",
            buttonForMyself = "//div[text()='Для себя']",
            inputForText = "//input[@name='%s']",
            inputForPassword = "//input[@name='%s']",
            textError = "//div[text()='%s']",
            partTextError = "//div[contains(text(), '%s')]",
            buttonFurther = "//span[text()='Далее']",
            headPageConfirmedEmail = "//h1[@data-a11y-title-piece and text()='%s']",
            textPageConfirmedEmail = "//p[@data-a11y-title-piece and text()='%s']",
            inputTypeEmailForAuth = "//input[@type='email']",
            avatarAuthUser = "//button[@id='avatar-btn']",
            loginEmail = "//yt-formatted-string[@id='email' and contains(text(), '%s')]",


end;
}
