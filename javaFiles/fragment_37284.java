import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlItalic;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlRadioButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class WebScrapper {

    private static final String TEXT = "some random text here";
    private static final String SWALLOW = "continental";
    private static final String COLOR = "indigo2";
    private static final String QUESTION = "why?";
    private static final String NAME = "Leo";

    /**
     * @param args
     * @throws IOException
     * @throws MalformedURLException
     * @throws FailingHttpStatusCodeException
     */
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {

        //to get the HTML Xpath, download and install firefox plugin Xpather from
        //http://jassage.com/xpather-1.4.5b.xpi
        //
        //then right-click on any part of the html and choose "show in xpather"
        //
        //HtmlUnit is a suite for functional web app tests (headless) with a
        //built-in "browser". Very useful for screen scraping.
        //
        //for HtmlUnit examples and usage, try
        //http://htmlunit.sourceforge.net/gettingStarted.html
        //
        //sometimes, the HTML is malformed, so you'll need to "clean it"
        //that's why I've also added JTidy to this project

        WebClient webClient = new WebClient();

        HtmlPage page = webClient.getPage("http://cgi-lib.berkeley.edu/ex/simple-form.html");

//        System.out.println(page.asXml());

        HtmlForm form = (HtmlForm) page.getByXPath("/html/body/form").get(0);

        HtmlTextInput name = form.getInputByName("name");
        name.setValueAttribute(NAME);

        HtmlTextInput quest = form.getInputByName("quest");
        quest.setValueAttribute(QUESTION);

        HtmlSelect color = form.getOneHtmlElementByAttribute("select", "name", "color");
        List<HtmlOption> options = color.getOptions();
        for(HtmlOption op:options){
            if (op.getValueAttribute().equals(COLOR)){
                op.setSelected(true);
            }
        }

        HtmlTextArea text = form.getOneHtmlElementByAttribute("textarea", "name", "text");
        text.setText(TEXT);

        //swallow
        HtmlRadioButtonInput swallow = form.getInputByValue(SWALLOW);
        swallow.click();

        HtmlSubmitInput submit = form.getInputByValue("here");

        //submit
        HtmlPage page2 = submit.click();

//        System.out.println(page2.asXml());

        String color2 = ((HtmlItalic)page2.getByXPath("//dd[1]/i").get(0)).getTextContent();
        String name2 = ((HtmlItalic)page2.getByXPath("//dd[2]/i").get(0)).getTextContent();
        String quest2 = ((HtmlItalic)page2.getByXPath("//dd[3]/i").get(0)).getTextContent();
        String swallow2 = ((HtmlItalic)page2.getByXPath("//dd[4]/i").get(0)).getTextContent();
        String text2 = ((HtmlItalic)page2.getByXPath("//dd[5]/i").get(0)).getTextContent();

        System.out.println(COLOR.equals(color2)
                && NAME.equals(name2)
                && QUESTION.equals(quest2)
                && SWALLOW.equals(swallow2)
                && TEXT.equals(text2));

        webClient.closeAllWindows();

    }

}