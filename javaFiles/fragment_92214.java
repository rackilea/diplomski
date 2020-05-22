String line;
List<String> list = new ArrayList();
BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToSearch));
while((line = bufferedReader.readLine()) != null) {
  arr[] = line.split(" ");
  for (int i = 0; i < arr.length; i++) {
      if(arr[i].contains("\\"))
      list.add(arr[i].substring(arr[i].indexOf("\\") + 1);
  }
return list;