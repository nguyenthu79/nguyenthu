package wait;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait {

    WebDriver driver;
    By MessContent = By.cssSelector("div.body-message>b");



    @Before
    public void Open() {
        this.driver = new ChromeDriver();
        this.driver.get("http://testmaster.vn/Account/Login?ReturnUrl=%2fadmin");
        this.driver.manage().window().maximize();

    }

    @Test
    public void TestWeb1() {
        Login login= new Login(this.driver);
        login.withUserName("ư453535").andPassword("sdad").perform();
        Assert.assertEquals(login.NoEmail(), "Hãy nhập E-mail ở định dạng: user@email.com");
    }
    @Test
    public void TestWeb2() {

        Login login= new Login(this.driver);
        login.withUserName("thu@gmail.com").andPassword("").perform();
        Assert.assertEquals(login.NoPass(), "Mật khẩu chỉ nhận giá trị chữ và số");

    }
 /*   @Test
    public void TestWeb3() {

        Login login= new Login(this.driver);
        login.withUserName("thu@gmail.com").andPassword("ẻwrwrwrwr").perform();
        Assert.assertEquals(login.AllPassEmail(), "");

    }
*/
    @After
    public void quid(){
        this.driver.quit();
    }

}


