package bawei.com.zhoukao1_lianxi2;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();
    List<ProBean.DataBean> str = new ArrayList<>();
    private Banner banner;
    String url = "http://120.27.23.105/ad/getAd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = (Banner) findViewById(R.id.banner);
        initdata();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if(str.get(position).getType()==1){
                    Toast.makeText(MainActivity.this,"我要跳转到商品详情页",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("strUrl",str.get(position).getUrl());
                    startActivity(intent);
                }

            }
        });
    }



    private void initdata() {
        new Asy().execute(url);
    }

    class Asy extends AsyncTask<String,Void,String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            ProBean bean = gson.fromJson(s, ProBean.class);
            List<ProBean.DataBean> data = bean.getData();
            str.addAll(data);
            for (int i = 0; i < data.size(); i++) {
                // 图片路径封装进集合
                list.add(data.get(i).getIcon());
            }

            banner.setImageLoader(new MyImageLoader());
            //为Banner设置实现轮播的图片路径的集合
            banner.setImages(list);
            //开启轮播
            banner.start();
        }

        @Override
        protected String doInBackground(String... params) {
            String s = NetWorkUtils.getJson(params[0]);
            return s;
        }
    }
}