import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class true_lab03 {
    public static void main(String[] args) throws IOException {
        String base = "https://student.mirea.ru/media/photo/";
        Document doc = Jsoup.connect(base).get();
        String title = doc.title();
        int num = 0;
        File folder = new File("D:\\", title);
        if(!folder.exists()) folder.mkdir();

        Elements fileHeadlines = doc.select("div.js-slide");

        for (Element el: fileHeadlines) {
            Element e = el.child(1).child(0);
            File fol = new File(folder.getPath(),e.text().replace("\"", ""));
            if(!fol.exists()) fol.mkdir();
            fol.setWritable(true);
            Document d = Jsoup.connect("https://student.mirea.ru" + el.child(2).attr("href")).get();
            Elements photos = d.select("div.row img.img-fluid");

            for (Element pic: photos) {
                URL url = new URL("https://student.mirea.ru"+ pic.attr("src"));

                InputStream is = url.openStream();
                OutputStream os = new FileOutputStream(fol.getPath()  + "\\" + num + ".jpg");

                num++;
                byte[] b = new byte[2048];
                int length;

                while ((length = is.read(b)) != -1) {
                    os.write(b, 0, length);
                }
                is.close();
                os.close();
            }
        }
    }
}
