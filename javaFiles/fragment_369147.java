void Save(File file)
{
 FileWriter writer = new FileWriter(file);

foreach (AddressBookEntry entry in this.entries)
{
this.SaveEntry(entry,writer);
}
} 


void SaveEntry(AddressBookEntry entry,  FileWriter writer)
{
  String record = entry.getFirstName() + "\t" + entry.getLastName() + "\t" +
  entry.getPhoneNumber();
  writer.write(record, 0, record.length();
}