public static void main(String[] args) {
    for(int i=0; i<=255; i++){
        byte a = (byte) i;
        byte[] num = new byte [] {(byte) a};
        System.out.println(num[0] + " : " + i + " : " + ((256+num[0]) % 256));
    }
}