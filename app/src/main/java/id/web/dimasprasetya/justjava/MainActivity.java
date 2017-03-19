package id.web.dimasprasetya.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // increase quantity of coffee
    public void increment(View view) {
        quantity += 1;
        displayValue(quantity);
    }

    // decrease quantity of coffe
    public void decrement(View view) {
        quantity -= 1;
        displayValue(quantity);
    }

    public void displayValue(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.value_text_view);
        quantityTextView.setText("" + number);
    }

    // submit order
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has wipped cream : " + hasWippedCream);

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check_box);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainAvticity", "Has chocolate : " + hasChocolate);

        int cost = calculatePrice(quantity, price);
        String priceMessage = createOrderSummary(cost, hasWippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    private int calculatePrice(int quantity, int pricePerCup) {
        return quantity * pricePerCup;
    }

    private String createOrderSummary(int cost, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name     : Dimas Prasetya";
        priceMessage += "\nAdd whipped cream ? " + addWhippedCream;
        priceMessage += "\nAdd chocolate ? " + addChocolate;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal    : " + cost;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    public void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.valueOrderSummary_text_view);
        orderSummaryTextView.setText(message);
    }

    // cancel order
    public void cancelOrder(View view) {
        int quantity = 0;
        int price = 0;
        cancel(quantity);
        cancelPrice(price);
    }

    public void cancel(int number) {
        TextView valueTextView = (TextView) findViewById(R.id.value_text_view);
        valueTextView.setText("" + number);
    }

    public void cancelPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.valueOrderSummary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
