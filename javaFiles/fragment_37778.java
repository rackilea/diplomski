Selenium.prototype.getIsNetworkReady = function() {
    if(this.browserbot.topWindow.isNetworkReady) { //sometimes this method is called before the page has loaded the isNetworkReady function
        return this.browserbot.topWindow.isNetworkReady();
    }
    return false;
}