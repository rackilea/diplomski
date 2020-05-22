<MenuButton fx:id="searchCriteriaMenu" mnemonicParsing="false"
    nodeOrientation="LEFT_TO_RIGHT" onAction="#searchCriteriaMenu"
    styleClass="redButton" text="Search Criteria" textFill="WHITE"
    wrapText="true">
    <items>
        <CustomMenuItem fx:id="scMenuItem" hideOnClick="false" mnemonicParsing="false"
            style="-fx-background-color: transparent; -fx-padding: 0; -fx-margin: 0;">
            <content>

                <VBox fx:id="advancedSearchVbox" prefHeight="406.0" prefWidth="359.0"
                    style="-fx-font-weight: bold;">

                    <!-- etc etc etc -->
                </VBox>

            </content>
        </CustomMenuItem>
    </items>
    <!-- ... -->
</MenuButton>