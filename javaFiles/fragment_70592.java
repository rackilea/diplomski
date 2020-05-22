// Iterating over the ArrayList built by the Controller Class bound to the data source.
if(count < rows.size()){
       // Set the column values on the data set off the values store in the Data model class.
       row["product"] = rows.get(count).getProduct();
       row["date"] = rows.get(count).getDate();
       row["units"] = rows.get(count).getUnits();
       count++;
       return true;
}

return false;