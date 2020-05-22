import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import static com.sun.jna.platform.win32.WinUser.GWL_STYLE;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JNATest extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        TextArea ta = new TextArea("output\n");
        VBox root = new VBox(5,ta);
        Scene scene = new Scene(root,800,200);
        stage.setTitle("Find this window");
        stage.setScene(scene);
        stage.show();
        //gets this window (stage)
        long lhwnd = com.sun.glass.ui.Window.getWindows().get(0).getNativeWindow();
        Pointer lpVoid = new Pointer(lhwnd);
        //gets the foreground (focused) window
        final User32 user32 = User32.INSTANCE;
        char[] windowText = new char[512];
        HWND hwnd = user32.GetForegroundWindow();
        //see what the title is
        user32.GetWindowText(hwnd, windowText, 512);
        //user32.GetWindowText(new HWND(lpVoid), windowText, 512);//to use the hwnd from stage
        String text=(Native.toString(windowText));
        //see if it's the same pointer
        ta.appendText("HWND java:" + lpVoid + " HWND user32:"+hwnd+" text:"+text+"\n");
        //change the window style if it's the right title
        if (text.equals(stage.getTitle())){
            //the style to change 
            int WS_DLGFRAME = 0x00400000;//s/b long I think
            //not the same constant here??
            ta.appendText("windows api:"+WS_DLGFRAME+" JNA: "+WinUser.SM_CXDLGFRAME);
            int oldStyle = user32.GetWindowLong(hwnd, GWL_STYLE);
            int newStyle = oldStyle & ~0x00400000; //bitwise not WS_DLGFRAME means remove the style
            newStyle = newStyle & ~0x00040000;//WS_THICKFRAME   
            user32.SetWindowLong(hwnd, GWL_STYLE, newStyle);
        }
    }

}