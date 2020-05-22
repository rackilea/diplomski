google.charts.load('current', {
  callback: drawChart,
  packages:['corechart']
});

function drawChart() {
  var colorPalate = ["#0d2713", "#8b9061", "#4cb274", "#898cca", "#02a4cf", "#d78e5d", "#87bd16", "#84b971", "#bacabe", "#766499", "#e51d85", "#287066", "#792b1b", "#401bec", "#0fdc3d", "#f6ade7", "#8fb4ad", "#de8456", "#16be99"];

  var j = ["Time",468.1666666666667,266.5333333333333,158,26.25,68.98,31.25,24.25,26.29,13,94.5,3.5,4,11.25,9];

  var data = new google.visualization.DataTable();

  for (var i = 0; i < j.length; i++) {
    if (i === 0) {
      data.addColumn("string", "Group");
    } else {
      data.addColumn("number", "Column " + i); // replace with affiliate
    }
  }

  data.addRow(j);

  chart = new google.visualization.BarChart(document.getElementById('chart_div'));
  var options = {
    'title':'Effort - ',
    'width':800,
    'height':660,
    is3D: true,
    colors: colorPalate
  };

  chart.draw(data, options);
}