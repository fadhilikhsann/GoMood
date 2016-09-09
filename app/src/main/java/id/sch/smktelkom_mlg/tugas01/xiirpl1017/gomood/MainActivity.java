package id.sch.smktelkom_mlg.tugas01.xiirpl1017.gomood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Spinner spFlavour;
    EditText customer;
    RadioGroup rgGelas;
    TextView tvHasil;
    CheckBox cbKoko, cbOreo, cbOvaltine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFlavour = (Spinner) findViewById(R.id.spinnerFlavour);

        findViewById(R.id.buttonOrder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
    }
}
