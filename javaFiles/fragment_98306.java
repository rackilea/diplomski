//Open source document
    Document document = new Document(inputFile);        

    //Forbid all privileges on the document
    DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();

    //Set the desired privileges
    PdfFileSecurity fileSecurity = new PdfFileSecurity(document);
    fileSecurity.setPrivilege(privilege);

    //Save resulting PDF document
    document.save(outputFile);