public void start(Stage stage) {
        Scene scene = new Scene(new Pane(new Label("Hello World")));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Find this window");
        stage.setScene(scene);
        stage.show();
        long lhwnd = com.sun.glass.ui.Window.getWindows().get(0).getNativeWindow();
        Pointer lpVoid = new Pointer(lhwnd);
        HWND hwnd = new HWND(lpVoid);
        final User32 user32 = User32.INSTANCE;
        int oldStyle = user32.GetWindowLong(hwnd, GWL_STYLE);
        System.out.println(Integer.toBinaryString(oldStyle));
        int newStyle = oldStyle | 0x00020000;//WS_MINIMIZEBOX
        System.out.println(Integer.toBinaryString(newStyle));
        user32.SetWindowLong(hwnd, GWL_STYLE, newStyle);
    }