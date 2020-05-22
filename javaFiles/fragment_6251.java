m = function (){
  emit( this.name , { totalDuration : this.duration , num : 1 } );
};

r = function (name, values){
  var n = {totalDuration : 0, num : 0};
  for ( var i=0; i<values.length; i++ ){
    n.totalDuration += values[i].totalDuration;
    n.num += values[i].num;
  }
  return n;
};

f = function(who, res){
  res.avg = res.totalDuration / res.num;
  return res;
};