private void Combine(BinaryMap bm, RectangleC rc, Point p, CombineFunction cf) {

    int[] target = ...;
    int[] src = ...
    cf.combine(target, source); // this will use the implementation you wrote when overriding the combine method
}