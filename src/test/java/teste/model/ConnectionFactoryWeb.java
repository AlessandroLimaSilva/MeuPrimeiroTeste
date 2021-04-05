package teste.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;


public class ConnectionFactoryWeb {

    private final String chromeDriver = "webdriver.chrome.driver";
    private final String pathChrome = "/home/ice/develop/driver/chromedriver_linux64/chromedriver";

    public WebDriver getConnection() throws WebDriverException {
        WebDriver browser = null;
        try {
            System.setProperty(chromeDriver, pathChrome);
            browser = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return browser;
    }

    public void closeConnection(WebDriver browser) throws WebDriverException{
        try{
            browser.quit();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }


    }


}
