package mobilecomputing.ssn.hans.lab5;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Insert extends AppCompatActivity {

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
        setContentView(R.layout.activity_insert);

        final SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("Bio",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        sqLiteDatabase.execSQL("create table if not exists info(name varchar(30) primary key,dob varchar(30),address varchar(50),phone varchar(15))");
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
                tv.setText(Integer.toString(dp.getDayOfMonth()) + "/" + Integer.toString(dp.getMonth() + 1) + "/" + Integer.toString(dp.getYear()));
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase.execSQL("insert into info values('"+name.getText().toString()+"','"+((TextView) findViewById(R.id.datedisp)).getText().toString()+"','"+((TextView) findViewById(R.id.address)).getText().toString()+"','"+((TextView) findViewById(R.id.phone)).getText()+"');");
                startActivity(new Intent(Insert.this,MainActivity.class));
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

}
