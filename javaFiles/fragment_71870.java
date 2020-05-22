import java.util.concurrent.atomic.AtomicBoolean;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.Element;
import org.w3c.dom.html.HTMLFormElement;

public class Main extends Application {
    @Override
    public void start( Stage stage ) throws Exception {
        stage.setTitle( "JavaFX WebView Example" );
        BorderPane borderPane = new BorderPane();
        WebView webviewBrowser = new WebView();
        borderPane.setCenter( webviewBrowser );
        final WebEngine engine = webviewBrowser.getEngine();
        engine.load( "http://gmail.com" );
        engine.setJavaScriptEnabled( true );
        final String username = "324jlk23j4l2klj34l2kj34l2jk34l2kj3lkjlajksdflkj@gmail.com";
        final String password = "password";
        final AtomicBoolean submitted = new AtomicBoolean();
        engine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed( ObservableValue<? extends Worker.State> ov,
                                         Worker.State oldState, Worker.State newState ) {
                        if ( newState == Worker.State.SUCCEEDED ) {
                            Element emailField = engine.getDocument().getElementById( "Email" );
                            if ( emailField != null ) {
                                emailField.setAttribute( "Value", username );
                            }
                            Element passwordField = engine.getDocument().getElementById( "Passwd" );
                            if ( emailField != null ) {
                                passwordField.setAttribute( "Value", password );
                            }
                            HTMLFormElement gaia_loginform = ( HTMLFormElement ) engine.getDocument().getElementById( "gaia_loginform" );
                            if ( gaia_loginform != null ) {
                                if ( !submitted.get() ) {
                                    submitted.set( true );
                                    gaia_loginform.submit();
                                }
                            }
                        }
                    }
                }
        );
        stage.setScene( new Scene( borderPane, 800, 600 ) );
        stage.show();
    }
}