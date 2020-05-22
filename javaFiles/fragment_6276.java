private byte[] toByteArray(File file) throws FileNotFoundException, IOException{  
    int length = (int) file.length();  
    byte[] array = new byte[length];  
    InputStream in = new FileInputStream(file);  
    int offset = 0;  
    while (offset < length) {  
        offset += in.read(array, offset, (length - offset));  
    }  
    in.close();  
    return array;  
    }