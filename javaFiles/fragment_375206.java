import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.TOCReference;
import nl.siegmann.epublib.epub.EpubReader;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
public class EPubDemo extends Activity {
    WebView webview;
    String line, line1 = "", finalstr = "";
    int i = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        webview = (WebView) findViewById(R.id.webview);
        AssetManager assetManager = getAssets();
        try {
            // find InputStream for book
            InputStream epubInputStream = assetManager
                    .open("sampleepubfile.epub");

            // Load Book from inputStream
            Book book = (new EpubReader()).readEpub(epubInputStream);

            // Log the book's authors
            Log.i("author", " : " + book.getMetadata().getAuthors());

            // Log the book's title
            Log.i("title", " : " + book.getTitle());

            /* Log the book's coverimage property */
            // Bitmap coverImage =
            // BitmapFactory.decodeStream(book.getCoverImage()
            // .getInputStream());
            // Log.i("epublib", "Coverimage is " + coverImage.getWidth() +
            // " by "
            // + coverImage.getHeight() + " pixels");

            // Log the tale of contents
            logTableOfContents(book.getTableOfContents().getTocReferences(), 0);
        } catch (IOException e) {
            Log.e("epublib exception", e.getMessage());
        }

        String javascrips = "";
        try {
            // InputStream input = getResources().openRawResource(R.raw.lights);
            InputStream input = this.getAssets().open(
                    "poe-fall-of-the-house-of-usher.epub");

            int size;
            size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            // byte buffer into a string
            javascrips = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // String html = readFile(is);

        webview.loadDataWithBaseURL("file:///android_asset/", javascrips,
                "application/epub+zip", "UTF-8", null);
    }

    @SuppressWarnings("unused")
    private void logTableOfContents(List<TOCReference> tocReferences, int depth) {
        if (tocReferences == null) {
            return;
        }

        for (TOCReference tocReference : tocReferences) {
            StringBuilder tocString = new StringBuilder();
             for (int i = 0; i < depth; i++) {
             tocString.append("\t");
             }
             tocString.append(tocReference.getTitle());
             Log.i("TOC", tocString.toString());

            try {
                InputStream is = tocReference.getResource().getInputStream();
                BufferedReader r = new BufferedReader(new InputStreamReader(is));

                while ((line = r.readLine()) != null) {
                    // line1 = Html.fromHtml(line).toString();
                    Log.v("line" + i, Html.fromHtml(line).toString());
                    // line1 = (tocString.append(Html.fromHtml(line).toString()+
                    // "\n")).toString();
                    line1 = line1.concat(Html.fromHtml(line).toString());
                }
                finalstr = finalstr.concat("\n").concat(line1);
                // Log.v("Content " + i, finalstr);
                i++;
            } catch (IOException e) {

            }

            logTableOfContents(tocReference.getChildren(), depth + 1);
        }
        webview.loadDataWithBaseURL("", finalstr, "text/html", "UTF-8", "");
    }
}