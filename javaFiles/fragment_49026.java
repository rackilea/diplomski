google.charts.load('current', {
  callback: drawVisualization,
  packages:['geochart']
});

function drawVisualization() {
  var query = new google.visualization.Query('https://docs.google.com/spreadsheets/d/1dTfxVvfDKn6iXn4W_m7HJ_86JOGNDsxYSSaXipEo0vM/edit#gid=0');
  query.send(handleQueryResponseTR);
}

function handleQueryResponseTR(response) {
  if (response.isError()) {
    console.log('Error in query: ' + response.getMessage() + ' ' +      response.getDetailedMessage());
    return;
  }

  var options = {
    backgroundColor: {fill:'#FFFFFF',stroke:'#FFFFFF' ,strokeWidth:0 },
    colorAxis:  {colors: ['#D95F0E','#FEC44F','#FEC44F','#FEC44F','#FEC44F','#FEC44F','#FEC44F','#FEC44F','#FEC44F','#FFF7BC','#FFF7BC','#FFF7BC','#FFF7BC',]},
    backgroundColor: {fill:'#FFFFFF',stroke:'#FFFFFF' ,strokeWidth:0 },
    datalessRegionColor: '#F5F0E7',
    displayMode: 'regions',
    enableRegionInteractivity: 'true',
    resolution: 'countries',
    sizeAxis: {minValue: 1, maxValue:1,minSize:10,  maxSize: 10},
    region:'world',
    keepAspectRatio: true,
    width:800,
    height:600,
    tooltip: {isHtml:'true',textStyle: {color: '#444444'}, trigger:'focus'}
  };

  var data = response.getDataTable();
  var view = new google.visualization.DataView(data);
  view.setColumns([0, {
    type:'string',
    label : 'num of',
    calc: function (dt, row) {
      return dt.getFormattedValue(row, 1) + ':  (' + dt.getFormattedValue(row, 2) + ' .)'
    },
    role: 'tooltip',
    p: {html: true}
  }]);
  var chart = new google.visualization.GeoChart(document.getElementById('visualization'));
  chart.draw(view, options);
}