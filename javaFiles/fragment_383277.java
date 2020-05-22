int additionalLength = clientKeyLength + processBytesLength;
if (totalSize + additionalLength > 64000) {
    sendToDatabase(partition, clientKeyBytesAndProcessBytesHolder);
    clientKeyBytesAndProcessBytesHolder.clear(); // watch out for gc
    totalSize = 0;
}
clientKeyBytesAndProcessBytesHolder.put(clientKeyBytes, processBytes);
totalSize += additionalLength;