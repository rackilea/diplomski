float inputSlot = (bitMultiplexed / (dataRate * 1000));
float outputSlot = ((1 / connectionsNum) * inputSlot);
int frameDuration = (connectionsNum * outputSlot);
System.out.println(inputSlot);
System.out.println(outputSlot);
System.out.println(frameDuration);