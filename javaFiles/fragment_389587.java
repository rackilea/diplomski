if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    if (xmlhttp.responseText != null) {
        var json = xmlhttp.responseText;
        var arr = JSON.parse(json);
        var data = arr[0].data;       // This is what you want to do?
        var chart = arr[0].chart;     // This is what you want to do?
        // try running alert(chart.xAxisName);
        // and so on