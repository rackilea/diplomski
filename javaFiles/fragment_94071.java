import java.net.URI;
import java.util.Collection;
import java.util.Objects;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class FrameOpener
extends Application {
    private static class FrameInfo {
        final String name;
        final String uri;

        FrameInfo(String name,
                  String uri) {

            this.name = name;
            this.uri = uri;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof FrameInfo) {
                FrameInfo other = (FrameInfo) obj;
                return Objects.equals(this.name, other.name) &&
                       Objects.equals(this.uri, other.uri);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, uri);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private ComboBox<FrameInfo> frameList;
    private WebView webView;

    @Override
    public void start(Stage stage) {
        String url;
        Collection<String> params = getParameters().getRaw();
        if (params.isEmpty()) {
            url = "https://docs.oracle.com/javase/10/docs/api/index.html" +
                "?overview-summary.html";
        } else {
            url = params.iterator().next();
        }

        frameList = new ComboBox<>();

        Label label = new Label("_Frame:");
        label.setMnemonicParsing(true);
        label.setLabelFor(frameList);

        Button showFrameButton = new Button("_Show frame");
        showFrameButton.setMnemonicParsing(true);
        showFrameButton.setOnAction(e -> showFrame());

        webView = new WebView();

        WebEngine engine = webView.getEngine();
        engine.getLoadWorker().stateProperty().addListener(
            (o, old, state) -> updateFrameList(state));
        engine.load(url);

        HBox framePane = new HBox(6, label, frameList, showFrameButton);
        framePane.setAlignment(Pos.BASELINE_CENTER);
        framePane.setFillHeight(true);
        framePane.setPadding(new Insets(12));

        Scene scene = new Scene(
            new BorderPane(webView, null, null, framePane, null));

        stage.setScene(scene);
        stage.setTitle("Frame Opener");
        stage.show();
    }

    private void updateFrameList(Worker.State loadState) {
        if (loadState == Worker.State.SUCCEEDED) {
            Document doc = webView.getEngine().getDocument();
            NodeList frames;
            try {
                XPath xpath = XPathFactory.newInstance().newXPath();
                frames = (NodeList) xpath.evaluate("//*" +
                    "[local-name() = 'frame'" +
                    " or local-name() = 'FRAME'" + 
                    " or local-name() = 'iframe'" + 
                    " or local-name() = 'IFRAME']" + 
                    "[@src]", doc, XPathConstants.NODESET);
            } catch (XPathException e) {
                throw new RuntimeException(e);
            }

            URI docURI = URI.create(webView.getEngine().getLocation());

            int count = frames.getLength();
            FrameInfo[] newFrameInfo = new FrameInfo[count];
            for (int i = 0; i < count; i++) {
                Element frame = (Element) frames.item(i);
                URI frameLocation = docURI.resolve(frame.getAttribute("src"));
                newFrameInfo[i] = new FrameInfo(
                    frame.getAttribute("name"), frameLocation.toString());
            }

            frameList.getItems().setAll(newFrameInfo);
            if (newFrameInfo.length > 0) {
                frameList.setValue(newFrameInfo[0]);
            }
        }
    }

    private void showFrame() {
        FrameInfo info = frameList.getValue();

        WebView frameView = new WebView();
        frameView.getEngine().load(info.uri);

        Stage stage = new Stage();
        stage.setTitle(info.name);
        stage.setScene(new Scene(new BorderPane(frameView)));
        stage.show();
    }
}