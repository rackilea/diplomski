StringBuilder sb = new StringBuilder(digest.length * 2);  

    Formatter formatter = new Formatter(sb);  
    for (byte b : digest) {  
        formatter.format("%02x", b);  
    }  

    return sb.toString();