ArrayList<Integer> receivedParts = new ArrayList<Integer>();

// save id of received packet
receivedParts.add(numPart);

// ...
// after transmission has finished

// Keep in mind that packets do not necessarily need to arrive in the same order like you've sent them when using UDP.
ArrayList<Integer> missingIDs = getMissingIDs(receivedParts);

for(Integer currentID : missingIDs) {

    // request missing packets
    requestMissingPacket(currentID);
}