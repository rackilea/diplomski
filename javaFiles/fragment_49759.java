j = 0;
int[][] shapes = {Circle_list, Rect_list, Tri_list};
for (int[] shape : shapes) {
    for(i=1; i<shape.length; ++i, j++) {
        mixCoor[j] = shape[i];
    }
}