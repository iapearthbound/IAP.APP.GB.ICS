package iap.app;

import iap.app.v3.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class HomeActivity extends Activity {
	
	WebView webview6;
	
	ProgressBar progressBar;
	
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        
    progressBar = (ProgressBar)findViewById(R.id.progressBar1);

    progressBar.setProgress(0);

    progressBar.setVisibility(View.VISIBLE);
    
    webview6 = (WebView) findViewById(R.id.webView6);webview6.setWebViewClient(new WebViewClient());
    
    webview6 = (WebView) findViewById(R.id.webView6);
    webview6.getSettings().setJavaScriptEnabled(true);
    webview6.getSettings().setBuiltInZoomControls(true);
        webview6.loadUrl("http://indandroidprj.zxq.net/app/app.home.php");
        
        final Activity myActivity = this;
        webview6.setWebChromeClient(new WebChromeClient() {
         public void onProgressChanged(WebView view, int progress) {
          // Activities and WebViews measure progress with different scales.
          // The progress meter will automatically disappear when we reach 100%
    	  myActivity.setTitle("Loading...");
    	  myActivity.setProgress(progress * 100);
         progressBar.setProgress(progress);
         if(progress == 100) {
        	 myActivity.setTitle(R.string.app_name);
         }
         }});
        
        
    }



@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && webview6.canGoBack()) {
        webview6.goBack();
        return true;
    }
    return super.onKeyDown(keyCode, event);
}

@Override
public void onConfigurationChanged(Configuration newConfig){        
    super.onConfigurationChanged(newConfig);
}

    
}

