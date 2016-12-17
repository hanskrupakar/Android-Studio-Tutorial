package mobilecomputing.ssn.hans.lab4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Pic extends AppCompatActivity {

    ImageView i;
    Button rotate,scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
        i = (ImageView)findViewById(R.id.imageView);
        rotate = (Button)findViewById(R.id.rotate);
        scale = (Button)findViewById(R.id.scale);
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setRotation((i.getRotation()+30)%360);
            }
        });
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setMaxWidth(i.getMaxWidth()*2);
                i.setMaxHeight(i.getMaxHeight()*2);
                i.setScaleX(i.getScaleX()*2);
                i.setScaleY(i.getScaleY()*2);
            }
        });
    }

}
