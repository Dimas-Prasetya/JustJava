package id.web.dimasprasetya.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // increase quantity of coffee
    public void increment(View view) {
        quantity += 1;
        displayIncrement(quantity);
    }

    public void displayIncrement(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.value_text_view);
        quantityTextView.setText("" + number);
    }

    // decrease quantity of coffe
    public void decrement(View view) {
        quantity -= 1;
        displayDecrement(quantity);
    }

    public void displayDecrement(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.value_text_view);
        quantityTextView.setText("" + number);
    }

    // submit order
    public void submitOrder(View view) {
        int cost = quantity * price;
        String priceMessage = "Total: Rp" + cost;
        priceMessage += "\nThank You!";
        displayMessage(priceMessage);
    }

    public void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.valuePrice_text_view);
        priceTextView.setText(message);
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
        TextView priceTextView = (TextView) findViewById(R.id.valuePrice_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
