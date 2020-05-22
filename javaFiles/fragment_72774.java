//convert search string to mysql format (note you can define variables for faster code and you should consider handling exceptions)
startDate = new SimpleDateFormat("yyyy-mm-dd").format(new SimpleDateFormat("dd/mm/yyyy").parse(startDate));
endDate = new SimpleDateFormat("yyyy-mm-dd").format(new SimpleDateFormat("dd/mm/yyyy").parse(endDate));

//syntax for query
... AND STR_TO_DATE(`Date`, '%d/%m/%Y') BETWEEN '"+startDate+"' AND '"+endDate+"';"