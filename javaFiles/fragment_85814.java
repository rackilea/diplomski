List<Integer> fromFile = new ArrayList<>();
InputStream fileReader = new ByteArrayInputStream("71123456".getBytes("utf-8"), 0, 8);
while (fileReader.available() > 0) 
{
  fromFile.add(fileReader.read());
}
int element = 0;
int count = 0;
List<Integer> seen = new ArrayList<>();
for (int i = 0; i < fromFile.size(); i++) 
{
  Integer recent = fromFile.get(i);
  if (seen.contains(recent)) 
  {
    count++;
    element = recent;
  }
  seen.add(recent);
}
if (count > 1) System.out.println(element);
fileReader.close();