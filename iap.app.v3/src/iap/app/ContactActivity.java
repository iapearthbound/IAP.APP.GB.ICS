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

public class ContactActivity extends Activity {
	
	WebView webview4;
	
	ProgressBar progressBar;
	
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);   

        progressBar = (ProgressBar)findViewById(R.id.progressBar1);

        progressBar.setProgress(0);

        progressBar.setVisibility(View.VISIBLE);
        
        webview4 = (WebView) findViewById(R.id.webView4);webview4.setWebViewClient(new WebViewClient());
        
        webview4 = (WebView) findViewById(R.id.webView4);
        webview4.getSettings().setJavaScriptEnabled(true);
        webview4.getSettings().setBuiltInZoomControls(true);
            webview4.loadUrl("http://indandroidprj.zxq.net/app/app.contact.php");
            
            final Activity myActivity = this;
            webview4.setWebChromeClient(new WebChromeClient() {
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
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview4.canGoBack()) {
            webview4.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){        
        super.onConfigurationChanged(newConfig);
    }
    

        
    }

