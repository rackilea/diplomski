"(SELECT (b.l2framessent - a.l2framessent) AS netl2framessent,CONVERT(endOfInterval*500, DATETIME) 
endOfInterval FROM (SELECT datetime DIV 500 startOfInterval,l2framessent FROM Statistics3,
(SELECT MIN(datetime) mindate FROM Statistics3 WHERE ipaddress='moteid' AND datetime BETWEEN '"+datetime1+"' AND '"+datetime2+"' 
GROUP BY datetime DIV 500) b WHERE ipaddress='"+moteid+"' AND datetime = mindate) a, 
(SELECT datetime DIV 500 endOfInterval, l2framessent FROM Statistics3, (SELECT MIN(datetime) mindate FROM Statistics3 WHERE 
ipaddress = '"+moteid+"' AND datetime BETWEEN '"+datetime1+"' AND '"+datetime2+"' GROUP BY datetime DIV 500) b WHERE 
ipaddress = '"+moteid+"'AND datetime = mindate) b WHERE endOfInterval = startOfInterval+ 1 ");