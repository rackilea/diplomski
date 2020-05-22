for (setBAction = 0; setBAction < numButtons.length; setBAction++) {

        numButtons[setBAction].addActionListener(new ActionListener() {
            private int value = setBAction;  // set on creation

            public void actionPerformed(ActionEvent e) {
                textArea.append("" + value);
            }

        });
    }