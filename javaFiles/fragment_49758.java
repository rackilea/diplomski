int mixColor[] = { Circle_list[0], Rect_list[0], Tri_list[0] };
int mixCoor[] = new int[Circle_list.length + Rect_list.length + Tri_list.length - 3];

int i, j=0;

for(i=1; i<Circle_list.length; ++i, j++) {
    mixCoor[j] = Circle_list[i];
}
for(i=1; i<Rect_list.length; ++i, j++) {
    mixCoor[j] = Rect_list[i];
}
for(i=1; i<Tri_list.length; ++i, j++) {
    mixCoor[j] = Tri_list[i];
}