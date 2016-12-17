package mobilecomputing.ssn.hans.lab4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class PrimitiveAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Graphic(this));
    }

    public class Graphic extends View{

        int x=0,s=1;

        public Graphic(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(Color.WHITE);
            p.setStyle(Paint.Style.FILL);
            canvas.drawPaint(p);
            canvas.drawRGB(0, 0, 0);
            p.setARGB(255, 255, 0, 0);
            canvas.drawRect(x, 350, x + 200, 400, p);
            p.setARGB(255, 0, 255, 255);
            canvas.drawRect(x + 50, 300, x + 150, 350, p);
            p.setARGB(255, 255, 255, 255);
            canvas.drawCircle(x + 50, 425, 25, p);
            canvas.drawCircle(x + 150, 425, 25, p);
            try {
                Thread.sleep(100,0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x+=s*50;
            if(x>(this.getWidth()-200))
                s=-1;
            if(x<0)
                s=1;
            invalidate();
        }
    }

}
