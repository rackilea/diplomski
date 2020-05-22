import java.io.IOException;

public class BannerTest {

 public static void main(String[] args) throws IOException {
     BannerReader reader = new BannerReader();
     BannerData bannerData = reader.readBanner();
     System.out.println(bannerData.getBanner());
 }
}