String maxDate = (String) globalMap.get("MaxDate");

if (maxDate != null && !maxDate.trim().isEmpty() )
    //Some Logic here to take the max i.e. Convert it to proper date format and compare them.
    globalMap.put("MaxDate", *comparedMaxDate*);
else
    globalMap.put("MaxDate", row4.DOCDATE);