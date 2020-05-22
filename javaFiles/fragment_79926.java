UniCommand cmd = udSess.command(); // Create an object to run the command
cmd.setCommand("SELECT customers WITH name LIKE 'Dan...' AND age GT '20'")
cmd.exec()

UniSelectList sl = udSess.selectList(0);

while (!sl.isLastRecordRead())
{
   UniString recordID = sl.next();
   // Read your record here, using recordID
}