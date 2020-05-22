public class CompareImage {

    static void processImage(String file1, String file2) {

        Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
        Image image2 = Toolkit.getDefaultToolkit().getImage(file2);

        try {
            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);

            int[] data1 = null;

            if (grab1.grabPixels()) {
                int width = grab1.getWidth();
                int height = grab1.getHeight();
                data1 = new int[width * height];
                data1 = (int[]) grab1.getPixels();
            }

            int[] data2 = null;

            if (grab2.grabPixels()) {
                int width = grab2.getWidth();
                int height = grab2.getHeight();
                data2 = new int[width * height];
                data2 = (int[]) grab2.getPixels();
            }

            System.out.println("Are these Images Identical ?: " + java.util.Arrays.equals(data1, data2));
            float similarity = compare(data1, data2);
            System.out.println("The similarity percent between the 2 images is: " + similarity + "%");

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    private static float compare(int[] data1, int[] data2) {
        if (data1.length == data2.length) {
            float totalPixelCount = data1.length;
            float matchedPixelCount = 0;
            for (int i = 0; i < data2.length; i++) {
                if (data1[i] == data2[i])
                    matchedPixelCount++;
            }
            return matchedPixelCount / totalPixelCount * 100;
        } else {
            return 0;
        }
    }

    public static void main(String args[]) {
        processImage("C:\\Users\\absin\\Downloads\\img_28136253.png",
                "C:\\\\Users\\\\absin\\\\Downloads\\\\img_281362531.png");
    }
}