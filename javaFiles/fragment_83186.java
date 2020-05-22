SoapObject response = (SoapObject)responseReturned.getProperty("diffgram");

response = (SoapObject)response.getProperty("NewDataSet");

SoapObject result = (SoapObject)response.getProperty(rowIndex); //this is start of the table. Needs to be looped row per row

txtName.setText(result.getProperty(colIndex).toString().trim()); //this is where you get the value from each column.