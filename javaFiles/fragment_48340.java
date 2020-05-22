google.charts.load('current', {
  callback: function () {
    var container = document.getElementById('chart_div');
    var chart = new google.visualization.BarChart(container);

    var dataTable = new google.visualization.DataTable();
    dataTable.addColumn('string', 'Person');
    dataTable.addColumn('number', '2010');
    dataTable.addColumn('number', '2020');
    dataTable.addColumn('number', '2030');
    dataTable.addColumn('number', '2040');
    dataTable.addColumn('number', '2050');

    dataTable.addRows([
      ['Time', 10, 14, 16, 22, 28]
    ]);

    chart.draw(dataTable, {
      colors: ["#0d2713", "#8b9061", "#4cb274", "#898cca", "#02a4cf", "#d78e5d", "#87bd16", "#84b971", "#bacabe", "#766499", "#e51d85", "#287066", "#792b1b", "#401bec", "#0fdc3d", "#f6ade7", "#8fb4ad", "#de8456", "#16be99"],
      bar: {
        gap: 4
      }
    });
  },
  packages:['corechart']
});