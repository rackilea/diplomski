import java.util.Arrays;

public class ImageProgram {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ImageReader().readImages()));
    }
}

class ImageReader {

    public int[] readImages() {
        int[][] images = readImagesInto2DArray();
        return makeOneDimensionArray(images);
    }

    private int[] makeOneDimensionArray(int[][] arrays) {
        int totalLength = computeTotalLength(arrays);
        int[] array = new int[totalLength];
        int destPos = 0;
        for (int[] subArray : arrays) {
            System.arraycopy(subArray, 0, array, destPos, subArray.length);
            destPos += subArray.length;
        }
        return array;
    }

    private int computeTotalLength(int[][] arrays) {
        int length = 0;
        for (int[] subArray : arrays) {
            length += subArray.length;
        }
        return length;
    }

    private int[][] readImagesInto2DArray() {
        int size = 24;
        int[][] result = new int[size][];
        for (int i = 0; i < size; i++) {
            result[i] = readArray(i + 1);
        }
        return result;
    }

    private int[] readArray(int index) {
        // read from file
        int[] result = new int[index];
        Arrays.fill(result, index);
        return result;
    }
}