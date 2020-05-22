public class TextGraphics {
    public static void main(String[] args) {

        displaySize size = new displaySize(5,5);
        displaySize.output(5,3,size,"H");
        displaySize.run(size);
    }

}

class displaySize {
    public static int indent;
    public static int sizeX = 0;
    public static int sizeY = 0;

    public displaySize() {

    }

    public displaySize(int screenX, int screenY) {

        sizeX = screenX;
        sizeY = screenY;
        indent = sizeX;
    }

    public static void output(int x, int y, displaySize size, String print) {
        rarray(size)[x + y * size.sizeX] = print;

    }

    public static String[] rarray(displaySize size) {
        String [] display;
        return display = new String[sizeX * sizeY];
    }

    public static void run(displaySize size) {
        int next = 0;
        for (int i = 0; i < sizeY; i++) {
            next++;
            for (int b = 0; b < indent; b++) {



                if(rarray(size)[next]==(null) )
                {
                    rarray(size)[next] = " ";
                    System.out.print( rarray(size)[next] + " ");

                }
                System.out.print( rarray(size)[next] + " ");
                }


            System.out.println("\n");
        }
    }



}