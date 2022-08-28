package Tests;

import Framewok.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NotepadTest extends TestBase
{
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
