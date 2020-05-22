public class JavaFxCalc extends Application {

    // All members are the same as your original code

    // public void handle(ActionEvent e) has been removed

    @Override
    public void start(Stage primaryStage) throws Exception {

        // All setup code is the same up until the for-loop below

        //sets preffered size for all buttons
        for (int x = 0; x < 16; x++) {
            numButtons[x].setPrefSize(50, 30);
        }

        // Add action handlers for the number buttons
        for (int x = 0; x < 14; x++) {
            // We need a final variable for the event handler
            final int index = x;
            if(x == 3 || x == 7 || x == 11) {
                // Skip the operation buttons, we won't hit 15 (+) here since the loop only goes to 13 (.)
                continue;
            }
            // This will create one unique event handler for each button.
            // Since we have the final index variable here we don't need to
            // iterate over the buttons to find the correct template position - we already know it
            numButtons[x].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent event) {
                    String numOne = resultsTextField.getText();
                    resultsTextField.setText(numOne + template[index]);
                }
            });
        }

        // Add action handlers for the operation buttons
        for (int x : new int[]{3, 7, 11, 15}) {
            numButtons[x].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent event) {
                    String firstNum = resultsTextField.getText();
                    num1 = Integer.parseInt(firstNum);
                    resultsTextField.setText("");
                    currentOperation = ((Button) event.getSource()).getText();
                }
            });
        }

        // Add action handler for the equals button
        numButtons[14].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                String secondNum = resultsTextField.getText();
                int num2 = Integer.parseInt(secondNum);

                switch (currentOperation) {
                    case "+":
                        num1 = num1 + num2;
                        resultsTextField.setText(String.valueOf(num1));
                        break;
                    case "-":
                        num1 = num1 - num2;
                        resultsTextField.setText(String.valueOf(num1));
                        break;
                    case "*":
                        num1 = num1 * num2;
                        resultsTextField.setText(String.valueOf(num1));
                        break;
                    case "/":
                        num1 = num1 / num2;
                        resultsTextField.setText(String.valueOf(num1));
                        break;
                    default:
                        break;
                }
            }
        });

        mainPane.getChildren().addAll(resultsTextField, topRow
                , middleRow, lowerRow, bottomRow);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}