for (int i=1;i<100;i++){ //i dont think so the max value will be larger than 100
if (request.getParameterValues("fromDate_"+i)==null ){
break;
}else{
fromDate[i]=request.getParameterValues("fromDate_"+i);
}
}