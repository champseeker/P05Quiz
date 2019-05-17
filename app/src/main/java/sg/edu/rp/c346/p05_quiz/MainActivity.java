package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox ckOneWay, ckRoundTrip ;
    EditText numPax;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ckOneWay = findViewById(R.id.oneWay);
        ckRoundTrip = findViewById(R.id.roundTrip);
        numPax = findViewById(R.id.NumPicker);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numPa = numPax.getText().toString();
                int pax = Integer.parseInt(numPa);

                if ( pax <= 0 ){

                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();

                }else{

                    if (ckOneWay.isChecked() && ckRoundTrip.isChecked()){

                        Toast.makeText(MainActivity.this, "PLease tick only 1 option for ticket type", Toast.LENGTH_SHORT).show();

                    }else if( ckRoundTrip.isChecked() ){

                        int price = (pax*100)*2 ;

                        Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                        intent.putExtra("value1","Round Trip");
                        intent.putExtra("value2",price);
                        startActivity(intent);

                    }else if ( ckOneWay.isChecked() ){

                        int price = (pax*100);

                        Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                        intent.putExtra("value1","One Way Trip");
                        intent.putExtra("value2",price);
                        startActivity(intent);

                    }

                }

            }
        });

    }
}
