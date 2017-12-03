package bawei.com.zhoukao1_lianxi2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dell on 2017/12/3.
 */

public class NetWorkUtils {
    public static String getJson(String uristring) {
        try {
            URL url = new URL(uristring);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(8000);
            int responseCode = urlConnection.getResponseCode();

            if (responseCode == 200) {
                //请求成功得到输入流
                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder builder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String data = "";

                while ((data = bufferedReader.readLine()) != null) {
                    builder.append(data);
                }
                return builder.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
