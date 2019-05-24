package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvShow = findViewById(R.id.textView3);

        Intent intentReceived = getIntent();
        String value1 = intentReceived.getStringExtra("value1");
        int value2 = intentReceived.getIntExtra("value2", 100);
        tvShow.setText("You have selected " + value1 + "\nYour air ticket coasts " + value2 );

    }
}
