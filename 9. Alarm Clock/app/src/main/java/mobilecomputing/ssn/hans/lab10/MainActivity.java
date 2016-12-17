package mobilecomputing.ssn.hans.lab10;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    AlarmManager am;
    PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am=(AlarmManager)getSystemService(ALARM_SERVICE);
        ((ToggleButton)findViewById(R.id.toggleButton)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    Toast.makeText(getApplicationContext(),"ALARM ON",Toast.LENGTH_SHORT).show();
                    Calendar c = Calendar.getInstance();
                    c.set(Calendar.HOUR_OF_DAY,((TimePicker)findViewById(R.id.timePicker)).getCurrentHour());
                    c.set(Calendar.MINUTE,((TimePicker)findViewById(R.id.timePicker)).getCurrentMinute());
                    Intent i = new Intent(MainActivity.this,AlarmReceiver.class);
                    pi = PendingIntent.getBroadcast(MainActivity.this,0,i,0);
                    am.set(AlarmManager.RTC,0,pi);
                }
                else
                {
                    am.cancel(pi);
                    Toast.makeText(getApplicationContext(),"Alarm OFF",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
