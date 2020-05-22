declare namespace h = "http://www.w3.org/1999/xhtml";

for $tr in /h:html/h:html[2]/h:body/h:div/h:table/h:tr
return
    <tr>{
        $tr/h:td[position() le 6]
    }</tr>