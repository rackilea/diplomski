private static final Locale RUSSIAN = new Locale("ru");

private static final String russian = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЬ" + // 41
                                      "ЭЮЯ1234567890";

button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String output = "";
            char[] input = textArea.getText().toUpperCase(RUSSIAN).toCharArray();
            int index;

            for (int i = 0; i < input.length; i++) {
                index = russian.indexOf(input[i]);
                System.out.printf("char: %c, index: %d%n", input[i], index);
                if (index >= 0)
                    output += codeMorse[index] + " ";
            }

            textArea.setText(output);
            button.setText("Конвертировано!");
        }
    });