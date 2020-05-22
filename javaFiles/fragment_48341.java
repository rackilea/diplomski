data.addColumn("string", "Group")

for(i=0; i < j.recordList.length; i++){
  data.addColumn("number", j.recordList[i]['Affiliate']);
}

var rowData = ["Time"];

for(i2=5; i2 < j.recordList.length; i2++){
  rowData.push(Number(j.recordList[i2]['Time']));
}

data.addRow(rowData);

chart = new google.visualization.BarChart(document.getElementById('chart_div'));
var options = {
  'title':'Effort - ' + value,
  'width':800,
  'height':660,
  is3D: true,
  colors: colorPalate
};

chart.draw(data, options);