package com.example.android.justjava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

CheckBox whippedCreamCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whippedCreamCheckBox = (CheckBox) findViewById(R.id.hasWhippedCream);
    }

    int quantity = 0;

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * When the checkbox is clicked
     * if checked then display message "true" in the order summary
     * if not checked then display message "false" in the order summary
     */
    public void onCheckboxClicked(View view) {

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        switch (view.getId()) {
            case R.id.hasWhippedCream:
                if (hasWhippedCream)
                    //With whipped cream
                    displayMessage("true");
                else
                    // Without whipped cream
                    displayMessage("false");
                break;
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Calculate the price with
        int price = calculatePrice();

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // String message
        displayMessage(createOrderSummary(price, hasWhippedCream));
    }

    /**
     * Calculates the price of the order
     *
     * @return the total price of coffees
     */
    public int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method is to create order summary
     *
     * @param price return text summary as a string message
     */
    private String createOrderSummary(int price, boolean hasWhippedCream) {
        String priceMessage = "ORDER SUMMARY";
        priceMessage += "\nName: Momen Ahmed";
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nAdd whipped cream " + hasWhippedCream;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    /**
     * This method displays the given price on the screen.
     */
    //////private void displayPrice(int number) {
    /////TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
    //////priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    ///////}

    /**
     * This method displays the given text on the screen.
     * <p/>
     * Variable assignment to the textview in XML file as
     * Variable data type Variable name = Value
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        orderSummaryTextView.setTextColor(Color.RED);
    }
}