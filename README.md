# Windows Desktop Application Automation with WinApp Driver on Java

This is a Java Mevan project with the dependencies:
- Selenium
- TestNG
- Appium Java Client

This solution has one test which opens the Windows Notepad application and run few tests on it. Before running this solution there few other dependencies you are required to fulfill. Which are:

1. Download and install the WinApp Driver application from here under releases: https://github.com/Microsoft/WinAppDriver
2. Download and install Windows SDK from here. When installing make sure you pick “Windows SDK signing tools for desktop apps” & “Windows SDK for UWP Managed apps” options in the installation process: https://developer.microsoft.com/en-us/windows/downloads/windows-sdk/
3. Since we are going to code with Java, download and install Java SDK if you don’t have already installed.
4. Set the "Developer Mode" of your Windows OS to True

Once you are done with the above steps you are good to try this sample project on your machine..

The TestBase of the sample framework is located under "src/test/java/Framework/TestBase.class". To run the code, open the project with IntelliJ (or any other preferred IDE) & locate the test files under the package "src/test/java/Tests/NotepadTest.class". You can simply run the test files from there

A descriptive explanation about the code base can be found on Medium.com: https://schathurangaj.medium.com/automating-windows-apps-using-winapp-driver-with-java-ffc7756c3ce6

## Feel free to Clone, Try-out & Optimize the code base as your wish!
