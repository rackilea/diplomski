inkedNotebook linkedNotebook1 = new LinkedNotebook();
linkedNotebook1.setShareName("<Name of notebook>");
linkedNotebook1.setUsername("evernote user id");
linkedNotebook1.setUri("uri of the public notebook");
notestore.createLinkedNotebook(linkedNotebook1, new OnClientCallback<LinkedNotebook>()  
{ 
   public void onSuccess(LinkedNotebook data) {
       notestore.getLinkedNotebookSyncChunk(data, 0, 100, true, new OnClientCallback<SyncChunk>() { 

        public void onSuccess(SyncChunk Syncdata) {
           SharedNotes = data.getNotes();
           }
        }

  }
 } );