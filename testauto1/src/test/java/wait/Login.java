package wait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    static WebDriver driver;
    By byUserName = By.cssSelector("input[type='email']");
    By byPassWord = By.cssSelector("body > div.login-form > div:nth-child(4) > input");
    By toolTip = By.cssSelector("div.tooltip");
    By popup= By.cssSelector("div.modal");
    By messpopup= By.cssSelector("div.body-message>b");

    public Login(WebDriver driver) {
        this.driver = driver;

    }

    public LoginBuilder withUserName(String username) {
        return new LoginBuilder(username);
    }

    public class LoginBuilder {
        String username;
        String password;
        String mess;

        public LoginBuilder(String username) {
            this.username = username;
        }

        public LoginBuilder andPassword(String password) {
            this.password = password;
            return this;
        }

        public void perform() {
            WebElement txtUserName = Login.driver.findElement(byUserName);
            WebElement txtPassWord = Login.driver.findElement(byPassWord);
            txtUserName.clear();
            txtUserName.sendKeys(username);
            txtPassWord.clear();
            txtPassWord.sendKeys(password);

            Login.driver.findElement(By.cssSelector("body > div.login-form > div.row-command > button")).click();

        }


    }

    public String NoEmail() {
        WebDriverWait wa = new WebDriverWait(Login.driver, 30);
        WebElement mm = wa.until(ExpectedConditions.presenceOfElementLocated(toolTip));
        String mess = "Hãy nhập E-mail ở định dạng: user@email.com";
        String failmesss = "Fail rui";

        if (mm.getText().equals(mess))

            return mess;
        else
            return failmesss;
    }

    public String NoPass() {
        WebDriverWait wa = new WebDriverWait(Login.driver, 30);
        WebElement mm = wa.until(ExpectedConditions.presenceOfElementLocated(toolTip));

        String mess = "Mật khẩu chỉ nhận giá trị chữ và số";
        String failmesss = "Fail rui";

        if (mm.getText().equals(mess))

            return mess;
        else
            return failmesss;
    }

  /* public String AllPassEmail() {

             Alert alert = driver.switchTo().alert();
            String alertMessage = driver.switchTo().alert().getText();
            alert.accept();

            //String  mm=this.driver.findElement(By.cssSelector("div.body-message>b")).getText();
            String mess = "Tên đăng nhập hoặc Mật khẩu không đúng.";
            String failmesss3 = "7y273shdf";

            if (alertMessage.equals(mess))

                return mess;

            else
                return failmesss3;

    }
*/

}

