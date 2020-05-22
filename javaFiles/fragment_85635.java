SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date validStartDate=null;
Date validEndDate=null;

try {
    validStartDate = df.parse(startDate);
    validEndDate = df.parse(endDate);

} catch (Exception e) {
    // are there any exceptions thrown and caught here?
}

// are validStartDate and validEndDate non-null at this point? 
// is this code even executed? it won't be if an exception was thrown...
Assigment a  = new Assignment(..., validStartDate, validEndDate);

// where did this "s" come from? did you mean "session.save(a)"?
session.save(s);