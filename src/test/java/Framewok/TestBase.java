package Framewok;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public static WindowsDriver notepadApp = null;
    protected String projectDirectory = System.getProperty("user.dir");

    @BeforeClass
    public void setup()
    {
        try
        {
            startWinAppDriver();
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

    @AfterClass
    public void cleanUp()
    {
        notepadApp.quit();
        setup();
    }

    @AfterSuite
    public void tearDown()
    {
        notepadApp.quit();
        try
        {
            Runtime runtime = Runtime.getRuntime();
            String command = "cmd /c" + projectDirectory + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "killProcesses.bat";
            runtime.exec(command);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void startWinAppDriver()
    {
        try
        {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(System.getenv("WAD_PATH")));
        }
        catch (IOException e)
        {
            System.out.println("Launching WinAppDriver failed");
            throw new RuntimeException(e);
        }
    }
}
