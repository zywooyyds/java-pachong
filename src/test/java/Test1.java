/**
 * @BelongsProject: java-pachong
 * @BelongsPackage: PACKAGE_NAME
 * @Author: lp
 * @CreateTime: 2023-01-30  14:46
 * @Description: 微信公众号图片爬取
 * @Version: 1.0
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test1 {

    public static void main(String[] args) throws IOException {

        // 获取该网页的url地址
        String url = "https://mp.weixin.qq.com/s/iMjUR-M6MMLQuFp2zYXYCQ";
        // 解析成文档对象
        Document document = Jsoup.parse(new URL(url), 10000);
        // 获取到父节点id为js_content的所有元素
        Element jsContent = document.getElementById("js_content");
        // 获取到标签为img的素有元素集合
        Elements imgs = jsContent.getElementsByTag("img");
        int id = 0;
        for (Element img : imgs) {
            //获取图片的url地址
            String attr = img.attr("data-src");
            // 获取输入流
            URL target = new URL(attr);
            URLConnection urlConnection = target.openConnection();
            // 获取输入流
            InputStream inputStream = urlConnection.getInputStream();
            id++;
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\img\\" + id + ".jpg");
            int temp = 0;
            while ((temp=inputStream.read())!=-1){
                fileOutputStream.write(temp);
            }
            System.out.println(id + ".jpg下载完毕");
            fileOutputStream.close();
            inputStream.close();

        }

    }

}
