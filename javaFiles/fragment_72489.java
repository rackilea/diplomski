public static void main(String[] args) {
    convert(MyOwnType.class, "Works!");
    convert(String.class, "Compilation Issue!");
}

static Object convert(Class<? extends MyType> targetType, String text) {
    PropertyEditor editor = PropertyEditorManager.findEditor(targetType);
    editor.setAsText(text);
    return editor.getValue();
}

static class MyOwnType extends MyType {

}

static abstract class MyType {

}