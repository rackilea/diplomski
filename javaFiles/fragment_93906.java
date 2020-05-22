class MyClass {
    private Button btnH;

    public void HButtonInitialise() {
        btnH = new Button(shell, SWT.NONE); // You are now assigning btnH which is accessible throughout the class
        // Write Rest of the code here
    }

    public void HButtonFunctionality() {
        // You can now freely access btnH here
    }
}