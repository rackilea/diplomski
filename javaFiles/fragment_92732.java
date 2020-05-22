new Morris.Bar({
   // ID of the element in which to draw the chart.
   element: 'pesanan-chart-area',
   data: $.parseJSON(json_data),
   xkey: 'tahun',
   ykeys: ['jml'],
   labels: ['Jumlah'],
   smooth: false
});