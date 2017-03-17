package id.web.dimasprasetya.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        int cost = calculatePrice(quantity, price);
        String priceMessage = createOrderSummary(cost);
        displayMessage(priceMessage);
    }

    private int calculatePrice(int quantity, int pricePerCup) {
        return quantity * pricePerCup;
    }

    private String createOrderSummary(int cost) {
        String priceMessage = "Name     : Dimas Prasetya";
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
