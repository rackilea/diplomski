import module namespace http = "http://expath.org/ns/http-client";
declare namespace h = "http://www.w3.org/1999/xhtml";

for $tr in http:send-request(<http:request href="http://www.pacra.com.pk/reports.php" method="get"/>)[2]/h:html/h:html[2]/h:body/h:div/h:table/h:tr
return
    <tr>{
        $tr/h:td[position() le 6]
    }</tr>