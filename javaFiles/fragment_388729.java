byte b = (byte)
    ((str.charAt(5) - '0') * 1 +
    (str.charAt(4) - '0') * 2 + 
    (str.charAt(3) - '0') * 4 + 
    (str.charAt(2) - '0') * 8 + 
    (str.charAt(1) - '0') * 16 + 
    (str.charAt(0) - '0') * 32);