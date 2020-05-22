import com.gargoylesoftware.htmlunit._
import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.html.DomElement

object AtomicTime {

  def main(args: Array[String]): Unit = {
    val url = "http://tycho.usno.navy.mil/what.html"
    val client = new WebClient(BrowserVersion.CHROME)

    var response: HtmlPage = client.getPage(url)
    response.executeJavaScript("showTime")

    printf("Current AtomicTime: %s", getUpdatedRespose(response, client))
  }

  def getUpdatedRespose(page: HtmlPage, client: WebClient): String = {
    while (page.getElementById("USNOclk").asText() == "Loading...") {
      client.waitForBackgroundJavaScript(200)
    }
    return page.getElementById("USNOclk").asText()
  }
}