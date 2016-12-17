package mobilecomputing.ssn.hans.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Ans;
    String first;
    char sym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ans = (TextView)findViewById(R.id.textView);
        Ans.setText("0");
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ans.getText().toString() == "0")
                    Ans.setText("1");
                else
                    Ans.setText(Ans.getText().toString() + "1");
            }
        });
        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ans.getText().toString() == "0")
                    Ans.setText("2");
                else
                    Ans.setText(Ans.getText().toString() + "2");
            }
        });
        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ans.getText().toString()=="0")
                    Ans.setText("3");
                else
                    Ans.setText(Ans.getText().toString()+"3");
            }
        });
        ((Button)findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ans.getText().toString()=="0")
                    Ans.setText("4");
                else
                    Ans.setText(Ans.getText().toString()+"4");
            }
        });
        ((Button)findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ans.getText().toString()=="0")
                    Ans.setText("5");
                else
                    Ans.setText(Ans.getText().toString()+"5");
            }
        });
        ((Button)findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ans.getText().toString()=="0")
                    Ans.setText("6");
                else
                    Ans.setText(Ans.getText().toString()+"6");
            }
        });
        ((Button)findViewById(R.id.button7)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ans.getText().toString()=="0")
                    Ans.setText("7");
                else
                    Ans.setText(Ans.getText().toString()+"7");
            }
        });
        ((Button)findViewById(R.id.button8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ans.getText().toString()=="0")
                    Ans.setText("8");
                else
                    Ans.setText(Ans.getText().toString()+"8");
            }
        });
        ((Button)findViewById(R.id.button9)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ans.getText().toString()=="0")
                    Ans.setText("9");
                else
                    Ans.setText(Ans.getText().toString()+"9");
            }
        });
        ((Button)findViewById(R.id.button0)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Ans.getText().toString()!="0")
                    Ans.setText(Ans.getText().toString()+"0");
            }
        });
        ((Button)findViewById(R.id.clear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans.setText("0");
                sym='c';
                first="";
            }
        });
        ((Button)findViewById(R.id.dot)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans.setText(Ans.getText().toString()+".");
            }
        });
        ((Button)findViewById(R.id.pl)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first = Ans.getText().toString();
                Ans.setText("0");
                sym='+';
            }
        });
        ((Button)findViewById(R.id.mi)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first = Ans.getText().toString();
                Ans.setText("0");
                sym='-';
            }
        });
        ((Button)findViewById(R.id.mu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first = Ans.getText().toString();
                Ans.setText("0");
                sym='*';
            }
        });
        ((Button)findViewById(R.id.di)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first = Ans.getText().toString();
                Ans.setText("0");
                sym='/';
            }
        });
        ((Button)findViewById(R.id.eq)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(sym)
                {
                    case '+':Ans.setText(Float.toString(Float.parseFloat(first)+Float.parseFloat(Ans.getText().toString())));break;
                    case '-':Ans.setText(Float.toString(Float.parseFloat(first)-Float.parseFloat(Ans.getText().toString())));break;
                    case '*':Ans.setText(Float.toString(Float.parseFloat(first)*Float.parseFloat(Ans.getText().toString())));break;
                    case '/':if(Ans.getText().toString()!="0") Ans.setText(Float.toString(Float.parseFloat(first)/Float.parseFloat(Ans.getText().toString())));break;
                }
            }
        });
    }
}
