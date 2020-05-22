<VBox fx:id="presetVBox" prefHeight="580.0" prefWidth="180.0" style="-fx-background-color: white;">
    <padding>
        <Insets left="10.0" right="10.0"/>
    </padding>
    ...
    <Button fx:id="preset2Button" maxWidth="Infinity" mnemonicParsing="false"
            prefWidth="Infinity" text="Load Preset 2">
        <VBox.margin>
            <Insets top="10.0"/>
        </VBox.margin>
    </Button>
    <Region VBox.vgrow="ALWAYS" />
    <Button fx:id="savePresetButton" maxWidth="Infinity" mnemonicParsing="false"
            prefWidth="500.0" text="Save">
        <!-- This button needs to aligned to the bottom of the VBox -->
        <VBox.margin>
            <Insets top="10.0"/>
        </VBox.margin>
    </Button>
</VBox>