package iap.app;

import android.app.Activity;
import android.os.Bundle;

public class ExitActivity extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
        System.exit(0);

}
}
