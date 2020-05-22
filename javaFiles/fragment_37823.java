import java.io.File;

    import java.io.FileInputStream;

    import java.io.IOException;

    import org.apache.commons.net.ftp.FTP;

    import org.apache.commons.net.ftp.FTPClient;

    import android.util.Log;



    public class MyOwn {

        public void goforIt(){


            FTPClient con = null;

            try
            {
                con = new FTPClient();
                con.connect("www.mysamle.net");                 // Its dummy Address

                if (con.login("uju495", "Stevejobs!!"))
                {
                    con.enterLocalPassiveMode();                   // Very Important

                    con.setFileType(FTP.BINARY_FILE_TYPE);        //  Very Important
                    String data = "/sdcard/Vivekm4a.m4a";

                    FileInputStream in = new FileInputStream(new File(data));
                    boolean result = con.storeFile("/Ads/Vivekm4a.m4a", in);
                    in.close();
                    if (result) Log.v("upload result", "succeeded");
                    con.logout();
                    con.disconnect();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }   
        }

    }