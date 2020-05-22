module Practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.fontawesomefx.fontawesome;

    opens sample to javafx.fxml;
    exports sample;
}