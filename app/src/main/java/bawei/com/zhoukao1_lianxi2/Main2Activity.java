package bawei.com.zhoukao1_lianxi2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        WebView viewById = (WebView) findViewById(R.id.wb);

        Intent intent = getIntent();
        String strUrl = intent.getStringExtra("strUrl");

        viewById.loadUrl(strUrl);
    }
}
