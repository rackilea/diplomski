if (!isReading) {
     isReading = line.startsWith(timestamp);
 }

 if (!isReading) {
     continue;
 }

 //otherwise process line