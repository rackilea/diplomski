//get the incremented counter without messing up the mask bits
//if already at highest value (2^30 - 1, or 1073741823, reset to 0)
private int custInc(int rawStamp){
    int markedBits = 0xC0000000 & rawStamp;
    if (getUnmarkedStamp(rawStamp) == 1073741823)
        return (0 | markedBits);
    else 
        return ((rawStamp + 1) | markedBits);
}

//get the stamp value without the marked bits
private int getUnmarkedStamp(int rawStamp){
    int stampMask = 0x3FFFFFFF;
    return stampMask & rawStamp;
}


//call this to determine if the AtomicStampedReference is pointing to an array node
//10XXXXX... indicates arrayNode;
//01XXXXX... indicates marked data node
//00XXXXX... indicates a normal data node
private boolean isStampArrayNode(int rawStamp){
    int isArrayNodeMask = 0xC0000000;
    if ((isArrayNodeMask & rawStamp) == 0x80000000)
        return true;
    else 
        return false;               
}

//call this to determine if the AtomicStampedReference is pointing to an marked data node
//10XXXXX... indicates arrayNode;
//01XXXXX... indicates marked data node
//00XXXXX... indicates a normal data node
private boolean isStampMarkedDataNode(int rawStamp){
    int isArrayNodeMask = 0xC0000000;
    if ((isArrayNodeMask & rawStamp) == 0x40000000)
        return true;
    else 
        return false;               
}

//call this to get what the raw stamp value if you are to mark it as a marked data node
//01XXXXX... indicates marked data node.ensure that this is returned
private int getStampMarkedAsDataNode(int rawStamp){
    return (rawStamp | 0x40000000) & 0x7FFFFFFF;
}

//call this to get what the raw stamp value if you are to mark it as an array node
//10XXXXX... indicates arrayNode;
private int getStampMarkedAsArrayNode(int rawStamp){
    return (rawStamp | 0x80000000) & 0xBFFFFFFF;
}