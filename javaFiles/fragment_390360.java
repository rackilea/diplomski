public class ArrayInitialize {
    public static void main(String ar[]){
        File file = new File("Image.jpg");
        BufferedImage img = new BufferedImage(240, 240, BufferedImage.TYPE_INT_ARGB);
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int p = img.getWidth();          // will be null
        int q = img.getHeight();         // same here
        int r = 3;
        int count = 0;
        int[][][] data = new int[p][q][r];
        for(int i=0;i<p;i++){
            for(int j=0;j<q;j++){
                for(int k=0;k<r;k++){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}