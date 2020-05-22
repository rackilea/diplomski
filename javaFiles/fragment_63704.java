import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

        IOException ioe = new IOException();
        //Initializing server
        System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
        ChromeDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //login
        System.out.println("*** login ***");
        wd.get("<URL>");
        wd.findElement(By.xpath("//form[@id='form']/div[1]/paper-input/paper-input-container/div[2]/div/input")).click();
        wd.findElement(By.xpath("//form[@id='form']/div[1]/paper-input/paper-input-container/div[2]/div/input")).clear();
        wd.findElement(By.xpath("//form[@id='form']/div[1]/paper-input/paper-input-container/div[2]/div/input")).sendKeys("<USERNAME>");
        wd.findElement(By.xpath("//form[@id='form']/div[2]/paper-input/paper-input-container/div[2]/div/input")).click();
        wd.findElement(By.xpath("//form[@id='form']/div[2]/paper-input/paper-input-container/div[2]/div/input")).clear();
        wd.findElement(By.xpath("//form[@id='form']/div[2]/paper-input/paper-input-container/div[2]/div/input")).sendKeys("<PASSWORD>");
        wd.findElement(By.xpath("//form[@id='form']//paper-button[.='login']")).click();
        try { Thread.sleep(3000l); } catch (Exception e) { throw new RuntimeException(e); }
        if(wd.findElement(By.tagName("html")).getText().contains("please login")){
            System.out.println("Login failed");
            throw ioe;
        }//End of login

        System.out.println("Login was executed successfully!");
        System.out.println("Testcase finished successfully!");
        wd.quit();