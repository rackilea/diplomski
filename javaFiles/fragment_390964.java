String serverIP = completeFileAddress.substring(0, index);
String filePath = completeFileAddress.substring(index, completeFileAddress.length()) + ".WAV";
if(filesMap.containsKey(serverIP))
{
   ArrayList<String> sourceList = filesMap.get(serverIP);
   sourceList.add(filePath);
}
else
{
   ArrayList<String> sourceList = new ArrayList<String>();
   sourceList.add(filePath);
   filesMap.put(serverIP, sourceFileList);
}