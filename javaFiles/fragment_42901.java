while(args.length>=argsPointer)
{
    byte[] argBytes = args[argsPointer].getBytes();
    for(int i = 0; i < argBytes.length; i++, bytePointer++) {
        ourMessage[bytePointer] = argBytes[i];
    }
    argsPointer++;
}