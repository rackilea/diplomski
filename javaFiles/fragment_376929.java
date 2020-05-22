public class AddGraphNode {
    public AddGraphNode(Editor editor, String tag, String name, String style, int vertPosX, int vertPoxY) {
        // **** note use of the editor parameter below ****
        editor.getGraph().getModel().beginUpdate();

        Object parent = editor.getGraph().getDefaultParent();
        Document doc = mxDomUtils.createDocument();
        Element entity = doc.createElement(tag);
        entity.setAttribute("name", name);
        try {
            // **** same here ****
            Object v1 = editor.getGraph().insertVertex(parent, "1", entity, vertPosX, vertPoxY,
                    (int) (name.length() * 8), 40, style);
        } finally {
            // **** and the same here ****
            editor.getGraph().getModel().endUpdate();
        }
    }
}