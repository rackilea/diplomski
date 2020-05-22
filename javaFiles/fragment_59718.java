POIFSFileSystem poifs = new POIFSFileSystem(fs);
Entry document = poifs.Root.GetEntry("Workbook");
DocumentInputStream docStream = new DocumentInputStream((DocumentEntry)document);
//RecordFactory factory = new RecordFactory();
//List<Record> records = RecordFactory.CreateRecords(docStream);
RecordFactoryInputStream recFacStream = new RecordFactoryInputStream(docStream, true);
Record currRecord;
while ((currRecord = recFacStream.NextRecord()) != null) 
   ProcessRecord(currRecord);