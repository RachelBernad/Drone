package e.win10user.drone;


/**
 * Created by Win10 User on 27.12.2017.
 */

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onCreate() {
        super.onCreate();
        this.onTokenRefresh();
    }

    private static final String TAG = "MyFirebaseIIDService";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.

        sendRegistrationToServer(refreshedToken);}

        private void sendRegistrationToServer(String token) {
            // TODO: Implement this method to send token to your app server.
            SendMessage apiHandler = new SendMessage();
            Response response = apiHandler.post("{\"token\":\""+token);
            if (response.isSuccessful()) {
                final ResponseBody body = response.body();
                try {
                    Log.d(TAG, "Successful" + body.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Log.d(TAG, "body invalid");
            }
        }
    }

