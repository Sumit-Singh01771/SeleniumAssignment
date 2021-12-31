package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSeleniumScript {
    WebDriver driver;

    @BeforeMethod
    public void start() {
        System.out.println("Starting");

    }


    @Test
    public void LoginChrome() throws InterruptedException {

        //Initialize Selenium Webdriver and data of excel sheet
        ReadExcel excel = new ReadExcel("XcelData/ExcelDocument.xlsx");
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver_linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();

        //Initialize headless browser
      //  options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        // Locate and interact with web element
        driver.get("https://www.keka.com/");
        driver.findElement(By.xpath("//a[contains(text(),'login')]")).click();
        driver.findElement(By.id("email")).sendKeys(excel.getData(0, 0, 0));
        driver.findElement(By.cssSelector("div.login-container:nth-child(3) table.login-container-layout div.login-form-container div.credentials-container form:nth-child(5) div.login-form:nth-child(1) div.form-group div.login-button > button.btn.login-from-btn")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Login with Google')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(excel.getData(0, 0, 1));
        driver.findElement(By.xpath("//div[@id='passwordNext']/div/button/span")).click();
        driver.findElement(By.xpath("//body/xhr-app-root[1]/div[1]/xhr-left-nav[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]/span[2]")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.xpath("//body/xhr-app-root[1]/div[1]/employee-me[1]/div[1]/employee-attendance[1]/div[1]/div[1]/div[1]/div[1]/employee-attendance-logs[1]/div[1]/employee-attendance-list-view[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/span[1]")).click();
        driver.findElement(By.linkText("Regularize")).click();
        driver.findElement(By.xpath("//button[contains(text(),'+Add Log')]")).click();
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("09:45");
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/input[1]")).sendKeys("18:45");
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[3]/div[1]/textarea[1]")).sendKeys(excel.getData(0, 1, 0));
        driver.findElement(By.xpath("//button[contains(text(),'Request')]")).click();
        driver.quit();
    }

    @Test
    public void LoginFirefox() {


        //Initialize Selenium Webdriver
        ReadExcel excel = new ReadExcel("XcelData/ExcelDocument.xlsx");
        System.setProperty("webdriver.gecko.driver", "src/test/geckodriver-v0.30.0-linux64/geckodriver");
        //FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--headless");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        // Locate and interact with web element
        driver.get("https://www.keka.com/");
        driver.findElement(By.xpath("//a[contains(text(),'login')]")).click();
        driver.findElement(By.id("email")).sendKeys(excel.getData(0, 0, 0));
        driver.findElement(By.cssSelector("div.login-container:nth-child(3) table.login-container-layout div.login-form-container div.credentials-container form:nth-child(5) div.login-form:nth-child(1) div.form-group div.login-button > button.btn.login-from-btn")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Login with Google')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(excel.getData(0, 0, 1));
        driver.findElement(By.xpath("//div[@id='passwordNext']/div/button/span")).click();
        driver.findElement(By.xpath("//body/xhr-app-root[1]/div[1]/xhr-left-nav[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]/span[2]")).click();
        driver.findElement(By.linkText("Attendance")).click();
        driver.findElement(By.xpath("//body/xhr-app-root[1]/div[1]/employee-me[1]/div[1]/employee-attendance[1]/div[1]/div[1]/div[1]/div[1]/employee-attendance-logs[1]/div[1]/employee-attendance-list-view[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/span[1]")).click();
        driver.findElement(By.linkText("Regularize")).click();
        driver.findElement(By.xpath("//button[contains(text(),'+Add Log')]")).click();
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("09:45");
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/input[1]")).sendKeys("18:45");
        driver.findElement(By.xpath("//body/modal-container[1]/div[1]/div[1]/attendance-adjustment-request[1]/div[2]/form[1]/div[3]/div[1]/textarea[1]")).sendKeys(excel.getData(0, 1, 0));
        driver.findElement(By.xpath("//button[contains(text(),'Request')]")).click();
        driver.quit();


    }

    @AfterMethod
    public void AfterFIx() {
        System.out.println("Completed");
    }
}






