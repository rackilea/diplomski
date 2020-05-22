import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;


.....

BrowserMobProxy proxy = new BrowserMobProxyServer();
proxy.start(0);

Proxy selProxy = ClientUtil.createSeleniumProxy(proxy);

DesiredCapabilities cap = new DesiredCapabilities();
cap.setCapability(CapabilityType.PROXY, selProxy);


WebDriver driver = new FirefoxDriver(capabilities);

proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

proxy.newHar("mysite");

driver.get("http://tarunlalwani.com");


Har har = proxy.getHar();