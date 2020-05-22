import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

    public class SynchronizedWebViewsTest extends Application {

      protected class DifferencePanel extends GridPane {
        private Boolean scrolling = Boolean.FALSE;
        private WebView actualPane;
        private WebView expectedPane;

        public DifferencePanel() {
          setPadding(new Insets(20, 20, 20, 20));
          actualPane = new WebView();
          expectedPane = new WebView();
          setResultPanes();
          addRow(0, actualPane, expectedPane);
        }

        public void setHtml(WebView webView) {
          Platform.runLater(() -> {
            webView.getEngine().loadContent(createHtml());
          });
        }

        public void synchronizeScrolls() {
          wireViews(actualPane, expectedPane);
          wireViews(expectedPane, actualPane);
        }

        private void wireViews(WebView webView, WebView otherWebView) {
          webView.addEventHandler(Event.ANY, event -> {
            if (!scrolling.booleanValue()) {
              synchronized (scrolling) {
                scrolling = Boolean.TRUE;
                if (event instanceof MouseEvent) {
                  MouseEvent mouseEvent = (MouseEvent) event;
                  Point2D origin = webView.localToScreen(0, 0);
                  Point2D otherOrigin = otherWebView.localToScreen(0, 0);
                  double offsetX = otherOrigin.getX() - origin.getX();
                  double offsetY = otherOrigin.getY() - origin.getY();
                  double x = mouseEvent.getX();
                  double y = mouseEvent.getY();
                  double screenX = mouseEvent.getScreenX() + offsetX;
                  double screenY = mouseEvent.getScreenY() + offsetY;
                  MouseButton button = mouseEvent.getButton();
                  int clickCount = mouseEvent.getClickCount();
                  boolean shiftDown = mouseEvent.isShiftDown();
                  boolean controlDown = mouseEvent.isControlDown();
                  boolean altDown = mouseEvent.isAltDown();
                  boolean metaDown = mouseEvent.isMetaDown();
                  boolean primaryButtonDown = mouseEvent.isPrimaryButtonDown();
                  boolean middleButtonDown = mouseEvent.isMiddleButtonDown();
                  boolean secondaryButtonDown = mouseEvent.isSecondaryButtonDown();
                  boolean synthesized = mouseEvent.isSynthesized();
                  boolean popupTrigger = mouseEvent.isPopupTrigger();
                  boolean stillSincePress = mouseEvent.isStillSincePress();
                  MouseEvent otherMouseEvent =
                      new MouseEvent(otherWebView, otherWebView, mouseEvent.getEventType(), x, y, screenX,
                                     screenY, button, clickCount, shiftDown, controlDown, altDown, metaDown,
                                     primaryButtonDown, middleButtonDown, secondaryButtonDown, synthesized,
                                     popupTrigger, stillSincePress, null);
                  otherWebView.fireEvent(otherMouseEvent);
                }
                else {
                  otherWebView.fireEvent(event.copyFor(otherWebView, otherWebView));
                }
                scrolling = Boolean.FALSE;
              }
            }
          });
        }

        private String createHtml() {
          StringBuilder sb = new StringBuilder(1000000);
          for (int i = 0; i < 100; i++) {
            sb.append(String.format("<nobr>%03d %2$s%2$s%2$s%2$s%2$s%2$s%2$s%2$s</nobr><br/>\n",
                                    Integer.valueOf(i), "Lorem ipsum dolor sit amet "));
          }
          return sb.toString();
        }

        private void setResultPanes() {
          setHtml(actualPane);
          setHtml(expectedPane);
        }
      }


      public static void main(String[] args){
        launch(args);
      }

      @Override
      public void start(Stage dummy)  throws Exception {
        Stage stage = new Stage();
        stage.setTitle(this.getClass().getSimpleName());
        DifferencePanel differencePanel = new DifferencePanel();
        Scene scene = new Scene(differencePanel);
        stage.setScene(scene);
        differencePanel.synchronizeScrolls();
        stage.showAndWait();
      }
    }