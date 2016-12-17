package mobilecomputing.ssn.hans.lab9;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;

public class MainActivity extends AppCompatActivity {

    File x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.clear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText) findViewById(R.id.text)).setText("");
                Toast.makeText(getApplicationContext(), "Text Cleared", Toast.LENGTH_SHORT).show();
            }
        });
        ((Button)findViewById(R.id.del)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = new File("/sdcard/Hans.txt");
                x.delete();
                Toast.makeText(getApplicationContext(), "Delete Successful", Toast.LENGTH_SHORT).show();
            }
        });
        ((Button)findViewById(R.id.write)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = new File("/sdcard/Hans.txt");
                String data = ((EditText)findViewById(R.id.text)).getText().toString();
                try {
                    if(data!=null) {
                        if(!x.createNewFile())
                            Toast.makeText(getApplicationContext(),"CREATE FAILED",Toast.LENGTH_SHORT);
                        FileOutputStream fos = new FileOutputStream(x);
                        OutputStreamWriter osw = new OutputStreamWriter(fos);
                        osw.append(data);
                        osw.close();
                        fos.close();
                        Toast.makeText(getApplicationContext(), "Insert Successful", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button)findViewById(R.id.read)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = new File("/sdcard/Hans.txt");
                String text = "";
                try {
                    if (!x.isFile())
                        text = "NO FILE DETECTED!";
                    else {
                        FileInputStream fis = new FileInputStream(x);
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                        String aDataRow = "";
                        while ((aDataRow = br.readLine()) != null) {
                            text += aDataRow + "\n";
                        }
                        br.close();
                        fis.close();
                        Toast.makeText(getApplicationContext(), "Read Successful", Toast.LENGTH_SHORT).show();
                    }
                    ((EditText) findViewById(R.id.text)).setText(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
