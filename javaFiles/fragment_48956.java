// Write a custom toolkit
public class MyToolkit extends sun.awt.windows.WToolkit 
{
  public void beep() {
  }
}

// Set this property
System.setProperty("awt.toolkit", "MyPackage.MyToolkit");