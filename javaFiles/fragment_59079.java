JSpinner notWorkingSpinner = new JSpinner(m2);
JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(notWorkingSpinner);
DateFormatter formatter = new DateFormatter( format );
notWorkingSpinner.setEditor(dateEditor);
dateEditor.getTextField().setFormatterFactory( new DefaultFormatterFactory( formatter ) );
formatter.setValueClass( DateThatAddsYear.class ); // Tell it to use a different value class!