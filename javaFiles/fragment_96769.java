public class Test {
    public void sizeOfTri(int triSize) { //Number of lines
        int line = 1;
        for(int i = 0; i < triSize; i++) { //Handles Each line
            int temp = triSize * 2;
            for(int j = 1; j < temp; j++) { //Handles Each space on the line
                if(j <= line && j == triSize || j >= temp - line && j == triSize) { //For the very last line because it needs an extra *
                    System.out.print("**");
                } else if(j <= line || j >= temp - line) { //For normal lines
                    System.out.print("*");
                } else if(j == triSize) {
                    System.out.print("  "); //For the second to last line because it needs an extra space to make it look mirrored
                } else { //For normal lines
                    System.out.print(" ");
                }
            }
            System.out.println();
            line++;
        }
    }

    public static void main(String[] args) {
        new Test().sizeOfTri(4);
    }
}