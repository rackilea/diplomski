FileOutputStream os = new FileOutputStream("C:\\Users\\David Laptop\\Documents\\Doc1.xml");
XMLEncoder encoder = new XMLEncoder(os);
for( int x = 0; x < people.length;x++)
  if (people[x] != null)
  {
    encoder.writeObject(people[x]);    
  }
}
encoder.close();