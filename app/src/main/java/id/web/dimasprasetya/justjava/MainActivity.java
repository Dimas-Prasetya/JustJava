package id.web.dimasprasetya.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int price = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // increase quantity of coffee
    public void increment(View view) {
        if (quantity == 10) {
            Toast.makeText(this, "You can't have more than 10 coffees!", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity += 1;
        displayValue(quantity);
    }

    // decrease quantity of coffe
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You can't have less than 1 coffees!", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity -= 1;
        displayValue(quantity);
    }

    public void displayValue(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.value_text_view);
        quantityTextView.setText("" + number);
    }

    // submit order
    public void submitOrder(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String valueName = nameEditText.getText().toString();
        // Log.v("MainActivity", "Name : " + valueName);

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWippedCream = whippedCreamCheckBox.isChecked();
        // Log.v("MainActivity", "Has wipped cream : " + hasWippedCream);

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check_box);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        // Log.v("MainAvticity", "Has chocolate : " + hasChocolate);

        int cost = calculatePrice(quantity, price, hasWippedCream, hasChocolate);
        String priceMessage = createOrderSummary(valueName, hasWippedCream, hasChocolate, cost);
        displayMessage(priceMessage);
    }

    /**
     *
     * @param quantity
     * @param pricePerCup
     * @param addWhippedCream
     * @param addChocolate
     * @return
     */
    private int calculatePrice(int quantity, int pricePerCup, boolean addWhippedCream, boolean addChocolate) {
        if (addWhippedCream) {
            pricePerCup += 1;
        }

        if (addChocolate) {
            pricePerCup += 2;
        }

        return quantity * pricePerCup;
    }

    /**
     *
     * @param addValueName      = add customer's name
     * @param addWhippedCream   = add whipped cream topping
     * @param addChocolate      = add chocolate cream topping
     * @param cost              = calculate the price
     * @return
     */
    private String createOrderSummary(String addValueName, boolean addWhippedCream, boolean addChocolate, int cost) {
        String priceMessage = "Name     : " + addValueName;
        priceMessage += "\nAdd whipped cream ? " + addWhippedCream;
        priceMessage += "\nAdd chocolate ? " + addChocolate;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal       : " + cost;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    public void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.valueOrderSummary_text_view);
        orderSummaryTextView.setText(message);
    }

}
