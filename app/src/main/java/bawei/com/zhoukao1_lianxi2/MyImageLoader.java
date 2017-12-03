package bawei.com.zhoukao1_lianxi2;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by dell on 2017/12/3.
 */

public class MyImageLoader extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        com.nostra13.universalimageloader.core.ImageLoader instance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        //通过ImageLoader设置图片
        instance.init(ImageLoaderConfiguration.createDefault(context));
        instance.displayImage((String) path, imageView);

    }
}
