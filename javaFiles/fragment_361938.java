// From your example
var scriptText = driver.findElement(By.xpath("//*[@id="player"]/script[2]/text()")).getText();

// run the regexp on the script text
var matches = scriptText.match(/url:\s+"([^"]+)"/);

// check if you found something
if (matches.length > 0) {
    var url = matches[1];
}