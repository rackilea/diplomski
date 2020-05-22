import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.BrowserVersion
import com.gargoylesoftware.htmlunit.html.HtmlPage

object ScrapeTest {

  def main(args: Array[String]): Unit = {
    val pageurl = "http://www.eci-polldaymonitoring.nic.in/psl/"
    val client = new WebClient(BrowserVersion.INTERNET_EXPLORER_8)
    // Don't throw exception on failing status code
    client.getOptions.setExceptionOnFailingStatusCode(false)

    var response: HtmlPage = client.getPage(pageurl)

    println(response.asText())
  }
}