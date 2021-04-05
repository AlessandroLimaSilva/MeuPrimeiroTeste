package teste;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import teste.model.ConnectionFactoryWeb;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrimeiroTeste {

    @Test
    public void testLoginUSJT() throws InterruptedException {

        ConnectionFactoryWeb conn = new ConnectionFactoryWeb();
        WebDriver browser = conn.getConnection();
        Dado dd = new Dado();


        //System.setProperty("webdriver.chrome.driver","/home/ice/develop/driver/chromedriver_linux64/chromedriver");
        //WebDriver browser = new ChromeDriver();

        //browser.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        browser.get("https://aluno.usjt.br/SOL/aluno/index.php/index/seguranca/dev/instituicao/8");
        Thread.sleep(2000);
        browser.findElement(By.name("matricula")).sendKeys(dd.usuario());
        browser.findElement(By.name("senha")).sendKeys(dd.senha());
        browser.findElement(By.name("logar")).click();
        Thread.sleep(6000);
        browser.findElement(By.className("ui-dialog-buttonset")).click();
        Thread.sleep(2000);
        String name = "Alexandro Lima da Silva";
        String ra = "201522705";
        String ok = "Resultado : OK\n"+"Usuario : "+name+"\nR.A | "+ra;
        String falha = "Resultado : Falhou\nUsuario nao encontrado";

        try{
            if (browser.getPageSource().contains(name) && browser.getPageSource().contains(ra)) {

                JOptionPane.showMessageDialog(null,ok);
            }else {
                JOptionPane.showMessageDialog(null,falha);
            }
        } catch (HeadlessException e) {
            e.printStackTrace();
        }

        Thread.sleep(1500);
        conn.closeConnection(browser);

    }
}
