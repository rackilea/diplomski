Pointer number;
    PointerByReference ref=new PointerByreference();
    int res=0;
    res = NativeInterface.FindNumber(null, ref); 
    number=ptr.getValue();
    IntByReference dataBufferSize = new IntByReference(1024);
    Pointer dataBuffer = new Memory(1024);                                                                  
    res = NativeInterface.GetData(number, 6, dataBuffer, dataBufferSize);                            
    if (res == 0) {                         
        byte buffer[] = dataBuffer.getByteArray(0, dataBufferSize.getValue());
        String bufferContent = new String(buffer, StandardCharsets.UTF_8);
        System.out.println(bufferContent);                              
    }