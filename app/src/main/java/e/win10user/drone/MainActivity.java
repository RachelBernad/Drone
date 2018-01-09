package e.win10user.drone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private FirebaseAnalytics mFirebaseAnalytics;
    private MyFirebaseInstanceIDService mIDService;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the Firebase instance
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        //mIDService.onCreate();
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "USER");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        Intent send = new Intent(this, mIDService.getClass());
        startService(send);
    }


}
