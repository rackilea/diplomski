import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.*;

import java.io.IOException;

class CustomerDialogController {
    @FXML
    private Label customerName;

    private EventHandler<Event> customEventHandler = event -> {
        // handle the event...
    };

    void initData(Customer customer) {
        customerName.setText(customer.getName());
    }

    public EventHandler<Event> getCustomEventHandler() {
        return customEventHandler;
    }
}

public class EventHandling {
    public Stage showCustomerDialog(Customer customer) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customerDialog.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));

        CustomerDialogController controller = loader.getController();
        controller.initData(customer);

        stage.addEventHandler(Event.ANY, controller.getCustomEventHandler());
        stage.show();

        return stage;
    }    
}

class Customer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}