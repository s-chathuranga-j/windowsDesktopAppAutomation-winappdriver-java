import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NotepadTest
{
    private static WindowsDriver notepadApp = null;

    @BeforeClass
    public static void setup()
    {
        try
        {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
            caps.setCapability("platformName", "Windows");
            caps.setCapability("deviceName", "WindowsPC");
            notepadApp = new WindowsDriver(new URL("http://127.0.0.1:4723"), caps);
            notepadApp.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown()
    {
        notepadApp.quit();
    }

    @Test
    public void setTextOnNotepad()
    {
        String message = "Welcome to desktop app automation";
        notepadApp.findElementByClassName("Edit").click();
        notepadApp.findElementByClassName("Edit").sendKeys(message);
        Assert.assertEquals((notepadApp.findElementByClassName("Edit").getText()), message);
        notepadApp.findElementByClassName("Edit").clear();
    }

    @Test
    public void checkAboutWindow()
    {
        notepadApp.findElementByName("Help").click();
        notepadApp.findElementByName("About Notepad").click();
        notepadApp.findElementByName("OK").click();
    }
}
