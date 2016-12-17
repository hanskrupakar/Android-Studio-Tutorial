package mobilecomputing.ssn.hans.lab6;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView text;
    String string;
    boolean r;
    Random rand;
    int[] colors={Color.CYAN,Color.GRAY,Color.YELLOW,Color.BLUE,Color.GREEN,Color.MAGENTA,Color.RED};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textView);
        string = text.getText().toString();
        r=false;
        rand=new Random();
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r==false)
                {
                    new Thread(){
                        public void run()
                        {
                            r=true;
                            while(true){
                                try{
                                sleep(250);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        string = string.substring(1)+string.charAt(0);
                                        text.setText(string);
                                        text.setTextColor(colors[rand.nextInt(7)]);
                                    }
                                });
                                if(r==false)
                                    break;
                            }
                            catch (Exception e){
                            e.printStackTrace();
                            }
                        }
                    }
                    }.start();
                }
                else
                    r=false;
            }
        });
    }
}
