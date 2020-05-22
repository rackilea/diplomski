google.load('visualization', '1');   // Don't need to specify chart libraries!
google.setOnLoadCallback(drawVisualization);

function drawVisualization() {


    getChartData(function(data){
        var wrapper = new google.visualization.ChartWrapper({
            chartType: 'ColumnChart',
            dataTable: data,
            options: {
                'title': 'Density of Precious Metals, in g/cm^3',
            },
            containerId: 'vis_div'
        });

        wrapper.draw();
    });
    
}



function getChartData(complete) {
    $.getJSON('https://gist.githubusercontent.com/vgrem/f5b04c1c55b15ad1167f/raw/d04d79c1d4d0e9f3463f23d779d23fcdab89adff/density.json', function (json) {
        var dataTable = new google.visualization.DataTable(json);
        complete(dataTable);
    });
}