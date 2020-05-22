static int getMaxHeight(int n, Box[] arr) {
        int maxHeight = arr[0].height; // set max to be the first box
        Box previous = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int curHeight = arr[i].height;
            if (curHeight > Math.max(previous.height, maxHeight)) {
                maxHeight = curHeight;
            }
            else if (curHeight < Math.min(previous.height, maxHeight)) {
                maxHeight = maxHeight + curHeight;
            }
            previous = arr[i];
        }
        return maxHeight;
    }