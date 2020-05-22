$(document).ready(function() {

    var jsonObj = [
        {
            regionName: "India",
            outlets: [
                {
                    outletName: "outlet1",
                    personName: "debrup",
                    count: "430"
                },
                {
                    outletName: "outlet12",
                    personName: "debrup2",
                    count: "440"
                }
            ]
        }
    ];                 

    var html = '<table border="1">';
    $.each(jsonObj, function(i, region) {
        html += '<tr><td>' + region.regionName + '</th></tr>';
        html += '<tr><td></td>'
        $.each(region.outlets, function(x, outlet) {
                html += '<td><b>' + outlet.outletName + '</b></td>';
        });
        html += '</tr><tr>';
        html += '<td>personName</td>';
        $.each(region.outlets, function(key, value) {
            html += '<td>' + value.personName + '</td>';    
        });
        html += '</tr><tr>';
        html += '<td>count</td>';
        $.each(region.outlets, function(key, val) {
            html += '<td>' + val.count + '</td>';
        });
        html += '</tr>';

    });
    html += '</table>';

    $("#table").html(html);
});