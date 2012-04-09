package iap.app;


import iap.app.v3.R;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AndroidTabLayoutActivity extends TabActivity{
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       

        
        TabHost tabHost = getTabHost();
        
        // Tab for Twitter News Feed
        TabSpec homespec = tabHost.newTabSpec("");
        homespec.setIndicator("", getResources().getDrawable(R.drawable.icon_home));
        Intent homeIntent = new Intent(this, HomeActivity.class);
        homespec.setContent(homeIntent);
        
        // Tab for Twitter News Feed
        TabSpec newsspec = tabHost.newTabSpec("");
        newsspec.setIndicator("", getResources().getDrawable(R.drawable.icon_news));
        Intent newsIntent = new Intent(this, NewsActivity.class);
        newsspec.setContent(newsIntent);
        
        // Tab for Downloads
        TabSpec downloadsspec = tabHost.newTabSpec("");
        // setting Title and Icon for the Tab
        downloadsspec.setIndicator("", getResources().getDrawable(R.drawable.icon_downloads));
        Intent downloadsIntent = new Intent(this, DownloadsActivity.class);
        downloadsspec.setContent(downloadsIntent);
        
        // Tab for Forum News Feed
        TabSpec forumspec = tabHost.newTabSpec("");
        forumspec.setIndicator("", getResources().getDrawable(R.drawable.icon_forum));
        Intent forumIntent = new Intent(this, ForumActivity.class);
        forumspec.setContent(forumIntent);
        
        // Tab for Contact Form
        TabSpec contactspec = tabHost.newTabSpec("");
        contactspec.setIndicator("", getResources().getDrawable(R.drawable.icon_contact));
        Intent contactIntent = new Intent(this, ContactActivity.class);
        contactspec.setContent(contactIntent);
        
        // Tab for Donate
        TabSpec donatespec = tabHost.newTabSpec("");
        donatespec.setIndicator("", getResources().getDrawable(R.drawable.icon_donate));
        Intent donateIntent = new Intent(this, DonateActivity.class);
        donatespec.setContent(donateIntent);
        
        // Tab for Donate
        TabSpec exitspec = tabHost.newTabSpec("");
        exitspec.setIndicator("", getResources().getDrawable(R.drawable.icon_exit));
        Intent exitIntent = new Intent(this, ExitActivity.class);
        exitspec.setContent(exitIntent);
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(homespec); // Adding news tab
        tabHost.addTab(newsspec); // Adding news tab
        tabHost.addTab(downloadsspec); // Adding downloads tab
        tabHost.addTab(forumspec); // Adding forum tab
        tabHost.addTab(contactspec); // Adding contact tab
        tabHost.addTab(donatespec); // Adding donate tab
        tabHost.addTab(exitspec); // Adding exit tab
        

    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){        
        super.onConfigurationChanged(newConfig);
    }
    

    

}