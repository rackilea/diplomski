public class Toast {
    private String text = null;

    public Toast makeText(final String text) {
        this.text = text;
        return this;
    }

    public void show() {
        if (text == null) throw new IllegalStateException("Text must be set before you can call show.");
        System.out.println(text);
    }

    public static void main(final String[] args) {
        final Toast toast = new Toast();
        toast.makeText("test").show();

        final Toast toastError = new Toast();
        toastError.show();
    }
}