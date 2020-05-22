/**
 * Utility method to transfer focus from the given node into the
 * direction. Implemented to reflectively (!) invoke Scene's
 * package-private method traverse. 
 * 
 * @param node
 * @param next
 */
public static void traverse(Node node, Direction dir) {
    Scene scene = node.getScene();
    if (scene == null) return;
    try {
        Method method = Scene.class.getDeclaredMethod("traverse", 
                Node.class, Direction.class);
        method.setAccessible(true);
        method.invoke(scene, node, dir);
    } catch (NoSuchMethodException | SecurityException 
            | IllegalAccessException | IllegalArgumentException 
            | InvocationTargetException e) {
        e.printStackTrace();
    }
}

// usage, f.i. on change of selection of a comboBox 
combo.getSelectionModel().selectedItemProperty().addListener((source, ov, nv) -> {
    traverse(combo, Direction.NEXT);
});