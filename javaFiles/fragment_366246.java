System.gc(); // close any streams first

  String fileName = "SDS_DID.txt";
// A File object to represent the filename
File f = new File(fileName);

// Make sure the file or directory exists and isn't write protected
if (!f.exists())
  throw new IllegalArgumentException(
      "Delete: no such file or directory: " + fileName);

if (!f.canWrite())
  throw new IllegalArgumentException("Delete: write protected: "
      + fileName);


// Attempt to delete it
boolean success = f.delete();

if (!success)
  throw new IllegalArgumentException("Delete: deletion failed");