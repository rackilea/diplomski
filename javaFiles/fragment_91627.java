function generateRnDFootPrint(){ 

progressBar.showBar();     // progress bar appears 

location.href='<%= contextPath %>/saveMTP.do?method=getRnDFootPrintReport&orgCode=<%=orgCode%>&orgId=<%=orgId%>'; 

setTimeout(function(){progressBar.hideBar();},2000);


}