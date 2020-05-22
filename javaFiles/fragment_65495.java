public static void main(String[] args) {
        java.util.Random r = new java.util.Random();
        int i = r.nextInt(2);
        String s;
        if(i == 0){
            s = String.format("%d", r.nextInt());
        }
        else{
            s = String.format("%f", r.nextFloat());
        }
        System.out.println(s);
    }