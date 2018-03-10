package utils;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Keren on 12/01/2018.
 */

public class LiveGuardGPS extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(getBaseContext());
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
