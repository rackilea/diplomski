//gets table
var table= document.getElementById('table1');

//gets rows of table
var rowLen = table.rows.length;

//loops through rows    
for (i = 0; i < rowLen; i++){
   var oCells = table.rows.item(i).cells;
   var cellLen = oCells.length;
   for(var j = 0; j < cellLen; j++){
      /* get your cell info here */
      /* var cellVal = oCells.item(j).innerHTML; */
   }
}