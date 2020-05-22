JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("var result = []; " +
"var all = document.getElementsByTagName('*'); " +
"for (var i=0, max=all.length; i < max; i++) { " +
"    result.push({'tag': all[i].tagName, 'class': all[i].getAttribute('class')}); " +
"} " +
" return result; ");