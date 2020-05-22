if (editWidth.getText().toString().isEmpty()) {
    w = 0;
} else {
    try {
         w = Double.parseDouble(width);
    } catch (NumberFormatException e) {
         // do something
    }
}

if (editHeight.getText().toString().isEmpty()) {
    h = 0;
} else {
    try {
         h = Double.parseDouble(height);
    } catch (NumberFormatException e) {
         // do something
    }
}