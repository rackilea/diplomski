function chk(d,e)
{

 var x = d.split('/')
 var y = e.split('/')
 var a = new Date(x[2],x[0],x[1])
 var b = new Date(y[2],y[0],y[1])
 var c = ( b - a )
 var p= c / (1000 * 60 * 60 * 24);
 return p;
}