import java.io.File; // Find Files
import java.io.IOException;

import java.awt.FileDialog; // File Picker

import javax.swing.JFrame; // JFrame

import java.nio.file.Paths;

class Files {

  public static void getApps(final File folder) {
      for (final File file : folder.listFiles()) {
           String fileName = file.getName();
           // System.out.println(fileName);
           // System.out.println(file.getPath());
          final File subfolder = new File(file.getPath()+"/Contents/Resources");
          if (subfolder.exists()) {
              String icon = pickFile(subfolder.getPath());
              if (icon == null) return;
              System.out.println("App Name: " + fileName);
              System.out.println("Icon Name: " + icon);
          } else {
              System.out.println("Directory not found...");
          }
      }
  }

public static String pickFile(String path) {
    FileDialog dialog = new FileDialog(new JFrame(), "Select File to Open");
    dialog.setMode(FileDialog.LOAD);
    dialog.setFilenameFilter((File dir, String name) -> name.endsWith(".icns"));
    dialog.setDirectory(path);
    dialog.setVisible(true);
    String fileChosen = dialog.getFile();
    return fileChosen;
}

public static void addAction(String cmd) {
    String text = "Text to save to file";
    try{
    java.nio.file.Files.write( Paths.get("/Users/Andrew/Desktop/testfile.txt"), text.getBytes());

    }catch(IOException e){
         System.err.print("Handle your error!");
    }
} 

public static void main (String[] args) {
    String action = "{\n\"BTTTouchBarButtonName\":\"Messages\",\n\"BTTTriggerType\":629,\n\"BTTTriggerClass\":\"BTTTriggerTypeTouchBar\",\n\"BTTPredefinedActionType\":49,\n\"BTTPredefinedActionName\":\"Launch Application \\/ Open File \\/ Start Apple Script …\",\n\"BTTLaunchPath\":\"file:\\/\\/\\/Applications\\/Messages.app\",\n\"BTTEnabled2\":1,\n\"BTTUUID\":\"F3089B96-FDEF-4D54-9DA8-9CCD3C7AF8A9\",\n\"BTTEnabled\":1,\n\"BTTRequiredModifierKeys\":1048576,\n\"BTTOrder\":1,\n   \"BTTIconData\":\"icondata\",\n\"BTTTriggerConfig\":{\n\"BTTTouchBarItemIconHeight\":22,\n\"BTTTouchBarItemIconWidth\":22,\n\"BTTTouchBarItemPadding\":0,\n\"BTTTouchBarFreeSpaceAfterButton\":\"5.000000\",\n\"BTTTouchBarButtonColor\":\"75.323769, 75.323769, 75.323769, 255.000000\",\n\"BTTTouchBarAlwaysShowButton\":\"1\",\n\"BTTTouchBarAlternateBackgroundColor\":\"0.000000, 0.000000, 0.000000, 0.000000\"\n}\n}";
    File f = new File("/Users/Andrew/Desktop/testfile.txt");
    try {f.createNewFile();}catch(Exception e){}
    addAction("open 'btt://add_new_trigger/?json="+action+"'");
    }

}