List params = new ArrayList();      
Map noteData = new HashMap();

noteData.put("ContactId", contactId);
noteData.put("ActionDescription", "My Note Title");
noteData.put("isAppointment", 0);
noteData.put("ActionDate","20170803T08:00:00");
noteData.put("CompletionDate","20171109");
noteData.put("CreationNotes", "Note data- what i want to save as note: bla bla bla..");

params.add(api_key);        
params.add("ContactAction");            
params.add(noteData);

Integer responseCode = (Integer) client.execute(
                "DataService.add", params);