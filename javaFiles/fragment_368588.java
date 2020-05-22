String data = "$GPGGA,1714.0,3723.465874,N,12202.26954,W,2,6,1.2,18.893,M,-25.669,M,2.0,0031*4F";
String[] parts = data.split(",");
String p2 = parts[2]; // 3723.465874
String p3 = parts[3]; // N
String p4 = parts[4]; // 12202.26954
String p5 = parts[5]; // W