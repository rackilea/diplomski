table.on('draw', function(){
  table.rows().data().each(function(value, index){
  alert('why it not coming in?');
  var node = table.row(index).node();

  if(value.container_cnt === 0){
  alert('hi');

  $(node).find("td.details-control").removeClass("td.details-control");
}