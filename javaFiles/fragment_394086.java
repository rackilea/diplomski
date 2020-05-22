// XHR post function
var sendXHRPost = void 0;
{
    sendXHRPost = function (url, params, callback) {
        var http = new XMLHttpRequest();
        http.open('POST', url, true);
        http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        http.onreadystatechange = function() {
            if (http.readyState === 4) {
                callback(http.status, http.responseText);
            }
        }
        http.send(params);
    }
}
// get your table data
var fetchTableData = void 0;
{
    fetchTableData = function () {
        sendXHRPost(
            'myURL', 
            // maybe you don't pass parameters to fetch your table?
            'parameterName=parameterValue', 
            function (responseStatus, responseText) {
                makeTable(responseStatus, JSON.parse(responseText);
            }
        );
    }
}
// formatter for your textarea cell
var textAreaCellFormatter = void 0;
{
    textAreaCellFormatter = function (rowId) {
        return '<textarea class="form-control push-text">'
            + rowId 
            + '</textarea>';
    }
}
// formatter for your buttons cell
var buttonsCellFormatter = void 0;
{
    buttonsCellFormatter = function (rowId) { 
        return  '<button type="button" '
            + 'class="btn btn-primary">'
            + 'save'
            + '</button>'
            + '<button type="button" '
            + 'class="btn btn-default" '
            + 'id="deletebutton'+rowId+'">'
            + 'delete'
            + '</button>';
    }
}
// build your table
var makeTable = void 0;
{
    makeTable = function (status, jsonResponse) {
        var table = document.getElementById("eeMsg");
        // Delete table content in case it was already loaded
        for (var i = 1 ; i < table.rows.length ; i++) {
            table.deleteRow(i); 
        }
        for (var i = 0 ; i < table.tBodies.length ; i++) {
            table.removeChild(table.tBodies[i]); 
        }
        // Create tbody
        var tBody = table.createTBody();
        // Handle internal server error
        if (status != 200) {
            var row = tBody.insertRow();
            var cell = row.insertCell(0);
            cell.colSpan = "4";
            cell.innerHTML = "Error while fetching data.";
        }
        // Handle no data found
        else if (jsonResponse.length === 0) {
            var row = tBody.insertRow();
            var cell = row.insertCell(0);
            cell.colSpan = "4";
            cell.innerHTML = "No data found.";
        }
        // All fine, build your table
        else {
            for(var i = 0 ; i < jsonResponse.length ; i++) {
                var row = tBody.insertRow();
                row.insertCell(0).innerHTML = jsonResponse[i].seq_no;
                row.insertCell(1).innerHTML = jsonResponse[i].type_big_category;
                row.insertCell(2).innerHTML = textAreaCellFormatter(i);
                row.insertCell(3).innerHTML = buttonsCellFormatter(i);
            }
        }
    }
}
// Execute your function on page loading.
(function () { fetchTableData(); })();