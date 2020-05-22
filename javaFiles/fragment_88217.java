processedSet = [ ]
keysWaiting = true
MAXFILE = 500
handlesMap = [ ]
while (keysWaiting) {
  keysWaiting = false
  open/rewind input file
  while (not EOF(input file)) {
    read message
    if (handlesMap.containsKey(messageKey)) {
       write data to handlesMap.get(messageKey)
    } else if (processedSet.contains(messageKey) {
       continue // already processed
    } else if (handlesMap.size < MAXFILE) {
       handlesMap.put(messageKey, new FileOutputStream(messageKey + ".dat")
       processedSet.add(messageKey)
       write data to handlesMap.get(messageKey)
    else
       keysWaiting = true
    endif
  }
  for all handlesMap.values() {
     close file handle
  }
  handlesMap.clear
}