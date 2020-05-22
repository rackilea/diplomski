class Test {

    public static void main(String[] args) {
        char[][] x = new char[3][3];
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (x[i][j] == 0){
                    System.out.println("This char is zero.");
                }
            }
        }
    }

}