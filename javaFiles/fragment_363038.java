import time
from selenium import webdriver

from browsermobproxy import Server
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
from selenium.webdriver.firefox.firefox_profile import FirefoxProfile

server = Server("/path/to/bin/browsermob-proxy")
server.start()
# If sleep is not added sometime `create_proxy` throws an error
time.sleep(2)
proxy = server.create_proxy()

sel_proxy = proxy.selenium_proxy()

profile = FirefoxProfile()
profile.set_proxy(sel_proxy)
driver = webdriver.Firefox(firefox_profile=profile)
proxy.new_har("mysite", options={'captureHeaders': True, 'captureContent': True} )
driver.get("http://tarunlalwani.com")
print(proxy.har)