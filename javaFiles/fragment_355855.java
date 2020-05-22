import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class TestBrowser {
    public static void main (String [] args) {
        Display display = new Display ();
        Shell shell = new Shell(display);

        shell.setLayout(new GridLayout());

        FXCanvas canvas = new FXCanvas(shell, SWT.NONE);
        canvas.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);
        canvas.setScene(scene);

        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        borderPane.setCenter(browser);

        createContextMenu(browser); //Creating a custom context menu works

        boolean test = browser.isContextMenuEnabled();
        System.out.println("WebView context menu enabled? "+test);

        webEngine.load("http://example.org");

        shell.open ();
        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }



    private static void createContextMenu(WebView webView) {

        MenuItem reload = new MenuItem("reload");
        reload.setOnAction(e -> {
            webView.getEngine().reload();
            }
        );
        ContextMenu contextMenu = new ContextMenu(reload);
        webView.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                System.out.println( webView.getEngine().executeScript("document.elementFromPoint("
                        +e.getX()
                        +"," +  e.getY()+").tagName;"));
                JSObject object = (JSObject) webView.getEngine().executeScript("document.elementFromPoint("
                        +e.getX()
                        +"," +  e.getY()+");");
                contextMenu.show(webView, e.getScreenX(), e.getScreenY());
            } else {
                contextMenu.hide();
            }
        });
    }
}