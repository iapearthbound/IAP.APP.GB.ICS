package iap.app;


import iap.app.v3.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class DownloadsActivity extends Activity {
	
	private Button button1, button2, button3, button4;
	
	WebView webview2;
	
	ProgressBar progressBar;
	
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloads_layout); 
        
        button1 = (Button) findViewById(R.id.button_kernels);
		 
		button1.setOnClickListener(new OnClickListener() {
 
		  public void onClick(View v) {
			  webview2.loadUrl("http://indandroidprj.zxq.net/app/app.kernels.php");
	                 button1.setBackgroundResource(R.drawable.background_focused);
	                 button1.setEnabled(false);
		             button2.setEnabled(true);
		             button3.setEnabled(true);
		             button4.setEnabled(true);
	                button2.setBackgroundResource(R.drawable.bkg);
	                button3.setBackgroundResource(R.drawable.bkg);
	                button4.setBackgroundResource(R.drawable.bkg);
		  }
 
		});
		
		button2 = (Button) findViewById(R.id.button_roms);
		 
		button2.setOnClickListener(new OnClickListener() {
 
		  public void onClick(View v) {
			  webview2.loadUrl("http://indandroidprj.zxq.net/app/app.roms.php");
	                 button2.setBackgroundResource(R.drawable.background_focused);
	                 button2.setEnabled(false);
		             button1.setEnabled(true);
		             button3.setEnabled(true);
		             button4.setEnabled(true);
		                button1.setBackgroundResource(R.drawable.bkg);
		                button3.setBackgroundResource(R.drawable.bkg);
		                button4.setBackgroundResource(R.drawable.bkg);
		  }
 
		});
		
		button3 = (Button) findViewById(R.id.button_themes);
		 
		button3.setOnClickListener(new OnClickListener() {
 
		  public void onClick(View v) {
			  webview2.loadUrl("http://indandroidprj.zxq.net/app/app.themes.php");

	                 button3.setBackgroundResource(R.drawable.background_focused);
	                 button3.setEnabled(false);
		             button1.setEnabled(true);
		             button2.setEnabled(true);
		             button4.setEnabled(true);
		                button1.setBackgroundResource(R.drawable.bkg);
		                button2.setBackgroundResource(R.drawable.bkg);
		                button4.setBackgroundResource(R.drawable.bkg);
		  }
 
		});
		
		button4 = (Button) findViewById(R.id.button_etc);
		 
		button4.setOnClickListener(new OnClickListener() {
 
		  public void onClick(View v) {
			  webview2.loadUrl("http://indandroidprj.zxq.net/app/app.etc.php");

	                 button4.setBackgroundResource(R.drawable.background_focused);
	                 button4.setEnabled(false);
		             button1.setEnabled(true);
		             button2.setEnabled(true);
		             button3.setEnabled(true);
		                button1.setBackgroundResource(R.drawable.bkg);
		                button2.setBackgroundResource(R.drawable.bkg);
		                button3.setBackgroundResource(R.drawable.bkg);
		  }
 
		});
        
        progressBar = (ProgressBar)findViewById(R.id.progressBar1);

        progressBar.setProgress(0);

        progressBar.setVisibility(View.VISIBLE);
        
        webview2 = (WebView) findViewById(R.id.webView2);webview2.setWebViewClient(new WebViewClient());
        
        webview2.setDownloadListener(new DownloadListener() {        
        	public void onDownloadStart(String url, String userAgent,                
        			String contentDisposition, String mimetype,                
        			long contentLength) {            
        		Intent intent = new Intent(Intent.ACTION_VIEW);            
        		intent.setData(Uri.parse(url));            
        		startActivity(intent);        }    });   
        
        webview2 = (WebView) findViewById(R.id.webView2);
        webview2.getSettings().setJavaScriptEnabled(true);
        webview2.getSettings().setBuiltInZoomControls(true);
            webview2.loadUrl("http://indandroidprj.zxq.net/app/app.downloads.php");
            
            final Activity myActivity = this;
            webview2.setWebChromeClient(new WebChromeClient() {
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
    public void onConfigurationChanged(Configuration newConfig){        
        super.onConfigurationChanged(newConfig);
    }
}
