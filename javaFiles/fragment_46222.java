areaBox.addFocusListener(generateFocusListener("Area", "Enter Area Name "));
cityBox.addFocusListener(generateFocusListener("City", "Enter City Name "));

FocusListener generateFocusListener(final String title, final String text) {
    return new FocusListener(){

            @Override
            @Deprecated
            public void onFocus(Widget widget) {
                // initial focus happens here
                TextBox box = (TextBox) widget;
                box.setTitle(title);
            }

            @Override
            public void onLostFocus(Widget widget) {
                // Focus is lost for the first time

                TextBox box = (TextBox) widget;
                if(box.getText().length() >= 4 )
                {
                    box.setStyleName("gwt-TextBox-Success");

                    // Change focus listener so that now once pressed it resets
                    box.addFocusListener(new FocusListener(){

                        @Override
                        @Deprecated
                        public void onFocus(Widget widget) {
                            TextBox box = (TextBox) widget;
                            box.setText(null);
                            box.setStyleName("gwt-TextBox-AE");
                        }

                        @Override
                        @Deprecated
                        public void onLostFocus(Widget widget) {
                            TextBox box = (TextBox) widget;
                            if(box.getText().length() >= 4 )
                            {
                                box.setStyleName("gwt-TextBox-Success");
                            }
                            else
                            {
                                box.setStyleName("gwt-TextBox-Error");
                                box.setText(text);
                            }

                        }

                    });
                }
                else
                {
                    box.setStyleName("gwt-TextBox-Error");
                    box.setText(text);
                }
            }

    };
}