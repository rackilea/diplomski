public static boolean arraysEquals(char[] arr1, char[] arr2, int length){
        return Arrays.equals(Arrays.copyOf(arr1, length -1), 
                        Arrays.copyOf(arr2, length -1));
    }

    //Usage

    arraysEquals(pngheader, fileheader, 4);
    arraysEquals(pngheader, fileheader2, 4);