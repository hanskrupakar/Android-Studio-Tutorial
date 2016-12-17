package mobilecomputing.ssn.hans.lab10;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.support.v4.app.NotificationCompat;

/**
 * Created by hans on 20/4/16.
 */
public class AlarmService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public AlarmService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationManager nm = (NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        PendingIntent pi = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
        NotificationCompat.Builder ncb = new NotificationCompat.Builder(this)
                .setContentTitle("ALARM")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("WAKE UP"));
        ncb.setContentIntent(pi);
        nm.notify(1,ncb.build());
    }
}
