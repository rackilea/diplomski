ResultSet resultSet = statement.executeQuery("SELECT * FROM table");

//Get a CSV writer settings object pre-configured for Excel
CsvWriterSettings writerSettings = Csv.writeExcel(); 
writerSettings.setHeaderWritingEnabled(true); //writes the column names to the output file

CsvRoutines routines = new CsvRoutines(writerSettings);
//use an encoding Excel likes
routines.write(resultSet, new File("/path/to/output.csv"), "windows-1252");