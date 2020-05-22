byte [] data3 = new byte[data.length];
for(int i = 0; i<data.length; i++){
    data3[i] = (byte)Math.abs(data2[i] - data[i]);
}

System.out.println("Subtracted Bytes: " + Arrays.toString(data3));