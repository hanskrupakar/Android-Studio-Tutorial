package mobilecomputing.ssn.hans.lab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.send)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(((EditText) findViewById(R.id.phone)).getText().toString(), null, ((EditText) findViewById(R.id.message)).getText().toString(), null, null);
            }
        });
    }
}
