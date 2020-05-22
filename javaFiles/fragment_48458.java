...

//I assume that the day of your lookupStartDate is the first day of month
Calendar myCal = Calendar.getInstance();
myCal.setTime(lookUpStartDate);    
myCal.add(Calendar.MONTH, +1);    
Date lookUpEndDate = myCal.getTime();

...

query.select(root).where(
    builder.and(
        builder.equal(root.get("house"), house),
        builder.greaterThanOrEqualTo(root.get("date"), lookUpStartDate),
        builder.lowerThan(root.get("date"), lookUpEndDate)
    )
);

...