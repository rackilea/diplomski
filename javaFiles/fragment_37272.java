class SubFunction {
    private String drawTribleX(){

        // *** move trible(t) inside drawTribleX() ***
        class Trible {
            private String trible(String t){
                return t + t + t;
            }
        }

        return new Trible().trible("X");
    }
    public static void main(String[] args){
        SubFunction o = new SubFunction();
        System.out.println(o.drawTribleX());
    }
}