if (emptyIndex == left || emptyIndex == right || emptyIndex == top
                || emptyIndex == bottom) {
            JButton emptyBtn = btns.get(emptyIndex);
            emptyBtn.setText(btn.getText());
            btn.setText("");
 }