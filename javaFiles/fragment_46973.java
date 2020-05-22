Map<String, String> entries = new HashMap<String,String>(1000);
StringBuilder entryData = null;
for line in file {
  if line starts with "<docFileNo" {
     docFileNo = extract number from line;
  } else if line starts with "<div=XXXpostag>" {
     // Content of this entry starts here
     entryData = new StringBuilder();
  } else if line starts with "</html>" {
     // content of this entry ends here
     // so store content, and indicate that the entry is finished by 
     // setting data to null
     entries.put(docFileNo, entryData.toString);
     entryData = null;
  } else if entryData is not null {
     // we're in an entry as data is not null, so store the line
     entryData.append(line);
  }
}