data.forEach(function(d) {
  //d.timestamp = new Date(d.timestamp*1000);
  d.close=+d.close;
}
var timeFormat = d3.time.format("%d %b %y %X");
var x = d3.time.scale().range([ 0, width ]);
var xAxis = d3.svg.axis().scale(x).orient("bottom").tickFormat(timeFormat);
x.domain(d3.extent(data, function(d) {
        return d.timestamp;
    }));