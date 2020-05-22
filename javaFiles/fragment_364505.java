int spriteCount = 16:
Map strMap = new HashMap();//add type
String str = incomintStr;
int hashStr = incomingStr.hashCode();
int location = hashStr % spriteCount;//a number less than the remaining counts
map.put(str,location);
sprite[location].put(str); 
spriteCount = spriteCount -1;