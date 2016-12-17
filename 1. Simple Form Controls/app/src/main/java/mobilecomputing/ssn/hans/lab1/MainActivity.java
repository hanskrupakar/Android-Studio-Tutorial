package mobilecomputing.ssn.hans.lab1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Console;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    Button b, submit, clear;
    TextView tv;
    EditText name;
    DatePicker dp;
    String text;
    public String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = "";
        name = (EditText)findViewById(R.id.name);
        submit = (Button)findViewById(R.id.submit);
        clear = (Button)findViewById(R.id.clear);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        b = (Button)findViewById(R.id.pick);
        tv = (TextView)findViewById(R.id.datedisp);
        dp = (DatePicker)findViewById(R.id.date);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(Integer.toString(dp.getDayOfMonth())+"/"+Integer.toString(dp.getMonth()+1)+"/"+Integer.toString(dp.getYear()));
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text += "\nNAME: "+name.getText();
                text += "\nDOB: "+((TextView) findViewById(R.id.datedisp)).getText();
                text += "\nEMAIL: "+((TextView) findViewById(R.id.email)).getText();
                text += "\nPHONE NO: "+((TextView) findViewById(R.id.phone)).getText();
                text += "\nADDRESS: "+((TextView) findViewById(R.id.address)).getText();
                text += gender;
                text += "\nLANGUAGES: ";
                if(((CheckBox)findViewById(R.id.eng)).isChecked())
                    text +="English \t";
                if(((CheckBox)findViewById(R.id.tam)).isChecked())
                    text +="Tamil \t";
                if(((CheckBox)findViewById(R.id.spa)).isChecked())
                    text +="Spanish \t";
                if(((CheckBox)findViewById(R.id.fre)).isChecked())
                    text +="French \t";
                Intent i = new Intent(MainActivity.this, Display.class);
                i.putExtra("text",text);
                startActivity(i);
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.male == checkedId)
                    gender = "\nGENDER: Male";
                else
                    gender = "\nGENDER: Female";
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                ((TextView) findViewById(R.id.datedisp)).setText("");
                ((TextView) findViewById(R.id.email)).setText("");
                ((TextView) findViewById(R.id.phone)).setText("");
                ((TextView) findViewById(R.id.address)).setText("");
                rg.clearCheck();
                ((CheckBox)findViewById(R.id.eng)).setChecked(false);
                ((CheckBox)findViewById(R.id.fre)).setChecked(false);
                ((CheckBox)findViewById(R.id.tam)).setChecked(false);
                ((CheckBox)findViewById(R.id.spa)).setChecked(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
