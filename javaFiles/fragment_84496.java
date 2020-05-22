QueryResult queryResults = connection.query("SELECT Id FROM Account WHERE Name = 'TEST'");
Account account = (Account) queryResults.getRecords()[0];
Event event = new Event();
[Set required fields]
event.setAccountId(account.getId());
Event[] records = new Event[1];
records[0] = event;
SaveResult[] saveResults = connection.create(records);