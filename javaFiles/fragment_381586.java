<AnchorPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="505.0" prefWidth="650.0" style="-fx-background-color: #4ce4ef;" xmlns="http://javafx.com/javafx/8.0.172-ea" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.CharlotteBronteController">
    <fx:define>
        <Image fx:id="redSeat" url="@../resources/seatsandicons/icons8-armchair-96.png" />
    </fx:define>
    <children>
        <GridPane alignment="CENTER" layoutX="194.0" layoutY="146.0" prefHeight="214.0" prefWidth="262.0">
            <columnConstraints>
                <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
                <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
                <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
            </columnConstraints>
            <rowConstraints>
                <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
                <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
                <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
            </rowConstraints>
            <children>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" onMouseClicked="#onClick">
                    <image>
                        <Image fx:id="greenSeat" url="@../resources/seatsandicons/icons8-armchair-96-3.png" />
                    </image>
                </ImageView>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" GridPane.columnIndex="1" onMouseClicked="#onClick">
                    <image>
                        <fx:reference source="greenSeat"/>
                    </image>
                </ImageView>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" GridPane.columnIndex="2" onMouseClicked="#onClick">
                    <image>
                        <fx:reference source="greenSeat"/>
                    </image>
                </ImageView>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" GridPane.rowIndex="1" onMouseClicked="#onClick">
                    <image>
                        <fx:reference source="greenSeat"/>
                    </image>
                </ImageView>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" GridPane.columnIndex="1" GridPane.rowIndex="1" onMouseClicked="#onClick">
                    <image>
                        <fx:reference source="greenSeat"/>
                    </image>
                </ImageView>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" GridPane.columnIndex="2" GridPane.rowIndex="1" onMouseClicked="#onClick">
                    <image>
                        <fx:reference source="greenSeat"/>
                    </image>
                </ImageView>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" GridPane.rowIndex="2" onMouseClicked="#onClick">
                    <image>
                        <fx:reference source="greenSeat"/>
                    </image>
                </ImageView>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" GridPane.columnIndex="1" GridPane.rowIndex="2" onMouseClicked="#onClick">
                    <image>
                        <fx:reference source="greenSeat"/>
                    </image>
                </ImageView>
                <ImageView fitHeight="80.0" fitWidth="80.0" pickOnBounds="true" preserveRatio="true" GridPane.columnIndex="2" GridPane.rowIndex="2" onMouseClicked="#onClick">
                    <image>
                        <fx:reference source="greenSeat"/>
                    </image>
                </ImageView>
            </children>
        </GridPane>
      <Label layoutX="227.0" layoutY="122.0" text="A" textFill="WHITE" />
      <Label layoutX="316.0" layoutY="122.0" text="B" textFill="WHITE" />
      <Label layoutX="400.0" layoutY="122.0" text="C" textFill="WHITE" />
      <Label layoutX="168.0" layoutY="168.0" text="1" textFill="WHITE" />
      <Label layoutX="168.0" layoutY="244.0" text="2" textFill="WHITE" />
      <Label layoutX="168.0" layoutY="312.0" text="3" textFill="WHITE" />
    </children>
</AnchorPane>