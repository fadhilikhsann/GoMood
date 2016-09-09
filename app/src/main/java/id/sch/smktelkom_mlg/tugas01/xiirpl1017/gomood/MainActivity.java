package id.sch.smktelkom_mlg.tugas01.xiirpl1017.gomood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    Spinner spFlavour;
    EditText etcustomer, etamount;
    RadioGroup rgGelas;
    RadioButton conee;
    TextView tvHasil;
    CheckBox cbKoko, cbOreo, cbOvaltine;
    int nTopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFlavour = (Spinner) findViewById(R.id.spinnerFlavour);
        etcustomer = (EditText) findViewById(R.id.editTextCustomer);
        etamount = (EditText) findViewById(R.id.editTextamount);
        rgGelas = (RadioGroup) findViewById(R.id.radioGroupGelas);
        conee = (RadioButton) findViewById(R.id.cone);
        cbKoko = (CheckBox) findViewById(R.id.koko);
        cbOreo = (CheckBox) findViewById(R.id.oreo);
        cbOvaltine = (CheckBox) findViewById(R.id.ovaltine);
        tvHasil = (TextView) findViewById(R.id.tvHasil);

        cbKoko.setOnCheckedChangeListener(this);
        cbOreo.setOnCheckedChangeListener(this);
        cbOvaltine.setOnCheckedChangeListener(this);

        findViewById(R.id.buttonOrder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {

        if (isValid()) {
            String nama, category;
            int flavour, topping, glass, jumlah, total;
            flavour = 0;
            topping = 0;
            glass = 0;
            nama = etcustomer.getText().toString();
            jumlah = Integer.parseInt(etamount.getText().toString());

            if (spFlavour.getSelectedItem().toString().equals("Cappucino")) {
                flavour = 3000;
                category = "spirit";
            } else if (spFlavour.getSelectedItem().toString().equals("Chocolate")) {
                flavour = 2000;
                category = "delicious";
            } else if (spFlavour.getSelectedItem().toString().equals("Durian")) {
                flavour = 5000;
                category = "spirit";
            } else if (spFlavour.getSelectedItem().toString().equals("Oreo")) {
                flavour = 3000;
                category = "awesome";
            } else if (spFlavour.getSelectedItem().toString().equals("Strawberry")) {
                flavour = 2000;
                category = "colorful";
            } else if (spFlavour.getSelectedItem().toString().equals("Vanilla")) {
                flavour = 2500;
                category = "beautiful";
            }

            if (cbKoko.isChecked()) topping += 1000;
            if (cbOreo.isChecked()) topping += 1000;
            if (cbOvaltine.isChecked()) topping += 2000;

            if (rgGelas.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgGelas.getCheckedRadioButtonId());

                if (rb.getText().toString().equals("Cone")) {
                    glass = 1500;
                } else if (rb.getText().toString().equals("Cup")) {
                    glass = 3000;
                }
            }

            total = (flavour + topping + glass) * jumlah;

            tvHasil.setText("Your name   : " + nama + "\n\nOrder   : " + jumlah + " Ice cream " + glass + " flavour " + flavour + " with " + nTopping + " topping. \n\nPrice    : ");


        }
    }

    private boolean isValid() {

        boolean valid = true;
        String customer = etcustomer.getText().toString();
        String amount = etamount.getText().toString();

        if (customer.isEmpty()) {
            etcustomer.setError("What's your name?");
            valid = false;
        } else if (customer.length() < 3) {
            etcustomer.setError("Please insert minimum 3 character from your name!");
            valid = false;
        } else {
            etcustomer.setError(null);
        }


        if (amount.isEmpty()) {
            etamount.setError("Insert your amount of your GoMood ice cream order!");
            valid = false;
        } else {
            etcustomer.setError(null);
        }

        if (!cbOreo.isChecked() || !cbOreo.isChecked() || !cbOreo.isChecked()) {
            cbOreo.setError("Choose your ice cream topping for make some happy!");
            valid = false;
        } else {
            cbOreo.setError(null);
        }

        if (rgGelas.getCheckedRadioButtonId() == -1) {
            conee.setError("Do you wanna some glass?");
            valid = false;
        } else {
            conee.setError(null);
        }


        return valid;

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nTopping += 1;
        else nTopping -= 1;
    }
}
