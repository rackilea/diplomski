NumericField letterDateField = new NumericField("date_of_letter",Field.Store.YES,true);
letterDateField.setLongValue(rs.getDate("DATE_OF_LETTER").getTime());
doc.add(letterDateField);
NumericField receivedDateField = new NumericField("date_received",Field.Store.YES,true);
receivedDateField.setLongValue(rs.getDate("DATE_RECEIVED").getTime());
doc.add(receivedDateField);