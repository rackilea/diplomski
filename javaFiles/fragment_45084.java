<input type="button" value="Show Log" onclick="showLog(logName)">

function showLog(logName) {
    var url = "/path-to-your-controller.html?logName=" + logName;
    window.open(url, "LogPage", "toolbar=no,location=no,menubar=no");
}