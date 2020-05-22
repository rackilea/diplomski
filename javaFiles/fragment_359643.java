public static boolean isCollide(Node x, Node y){
            Bounds RectA = x.localToScene(x.getBoundsInLocal());
            Bounds RectB = y.localToScene(y.getBoundsInLocal());

            return RectB.intersects(RectA);
}