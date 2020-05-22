import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class MoMoney extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        double balance = 12313.00;

        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String numberAsString = decimalFormat.format(balance);

        Text balanceText = new Text("$" + (numberAsString));
        balanceText.setFont(Font.font("Modernist", 72));
        balanceText.setFill(Color.web("77e6b3"));

        Text currencyText = new Text("USD");
        currencyText.setTextOrigin(VPos.TOP);
        currencyText.setFont(Font.font("Modernist", 36));
        currencyText.setFill(Color.web("77e6b3"));

        TextFlow flow = new TextFlow(balanceText, currencyText);
        flow.setMinSize(TextFlow.USE_PREF_SIZE, TextFlow.USE_PREF_SIZE);

        VBox layout = new VBox(flow);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.getScene().setFill(Color.rgb(35, 39, 50));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}