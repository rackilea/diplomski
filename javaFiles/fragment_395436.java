button.setText(txtList.get(X));

    if (X > -1 ) {
        X++;
        if (X == 5) {
            X -= 5;
        }
        }

    frame.repaint();

 }
}