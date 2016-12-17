package mobilecomputing.ssn.hans.lab5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    TextView tv;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        tv = (TextView)findViewById(R.id.text);
        tv.setText("");
        sqLiteDatabase = openOrCreateDatabase("Bio",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        Cursor c = sqLiteDatabase.rawQuery("select * from info;", null);
        if(c.moveToFirst()) {
            while(!c.isAfterLast()) {
                tv.setText(tv.getText().toString() + "\n\n\nDB ENTRY:\n" + c.getString(c.getColumnIndex("name")) + "\n" + c.getString(c.getColumnIndex("dob")) + "\n" + c.getString(c.getColumnIndex("address")) + "\n" + c.getString(c.getColumnIndex("phone")));
                c.moveToNext();
            }
        }
    }

}
