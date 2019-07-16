package PropellerADS.search;

public class Search_selectors {

    public String
            inputSearch = "//input[@id='search']",
            buttonSearch = "//button[@id='search-icon-legacy']",
            partHeadVideo = "//div[@id='dismissable']//*[contains(@title, '%s')]",
            elementPreview = "//div[@id='container']//div[@id='dismissable']",
            titleVideo = "//div[@id='container']//ytd-video-renderer[%s]//div[@id='dismissable']//a[@id='video-title']",
            textOnPageError = "//div[contains(@class, 'promo-message')]/div[text()='%s']",


    end;
}
