package iap.app;

import iap.app.v3.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ForumActivity extends Activity {
	
	private Button button1;
	
	WebView webview3;
	
	ProgressBar progressBar;
	
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_layout);
        
        
        button1 = (Button) findViewById(R.id.button_kernels);
		 
		button1.setOnClickListener(new OnClickListener() {
 
		  public void onClick(View v) {
			  webview3.loadUrl("http://indandroidprj.zxq.net/phpBB3/index.php");
	                 button1.setBackgroundResource(R.drawable.background_focused);
	                 button1.setEnabled(false);
		  }
 
		});
        
        progressBar = (ProgressBar)findViewById(R.id.progressBar1);

        progressBar.setProgress(0);

        progressBar.setVisibility(View.VISIBLE);
        
        webview3 = (WebView) findViewById(R.id.webView3);webview3.setWebViewClient(new WebViewClient());
        webview3.setDownloadListener(new DownloadListener() {        
        	public void onDownloadStart(String url, String userAgent,                
        			String contentDisposition, String mimetype,                
        			long contentLength) {            
        		Intent intent = new Intent(Intent.ACTION_VIEW);            
        		intent.setData(Uri.parse(url));            
        		startActivity(intent);        }    });   
        
        webview3 = (WebView) findViewById(R.id.webView3);
        webview3.getSettings().setJavaScriptEnabled(true);
        webview3.getSettings().setBuiltInZoomControls(true);
        

            webview3.loadUrl("http://indandroidprj.zxq.net/phpBB3/app.feed.php");
        
	


	  
 
            
            final Activity myActivity = this;
            webview3.setWebChromeClient(new WebChromeClient() {
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
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview3.canGoBack()) {
            webview3.goBack();
            button1.setBackgroundResource(R.drawable.bkg);
            button1.setEnabled(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){        
        super.onConfigurationChanged(newConfig);
    }
    



}
