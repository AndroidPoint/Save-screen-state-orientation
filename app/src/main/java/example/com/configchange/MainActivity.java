package example.com.configchange;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("http://www.youtube.com/channel/UCakhVD1UtmS7uVJA14QOxhA/videos?disable_polymer=true/");
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(false);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webview.getSettings().setAppCacheEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        webview.setWebViewClient(new WebViewClient());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webview.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            webview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String s = "";
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            s = "ORIENTATION_LANDSCAPE\n";
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            s = "ORIENTATION_Portrait\n";
        }
        s += "onConfigurationChanged () Was called" + ((Save) getApplicationContext()).ap() + "times";
        Toast.makeText(this ,s,Toast.LENGTH_LONG).show();


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}

