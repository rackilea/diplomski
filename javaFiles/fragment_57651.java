if (value >= 10 && value < 100) DecimalFormat formatter = new DecimalFormat("#.#########");
else if (value >= 100 && value < 1000)) DecimalFormat formatter = new DecimalFormat("#.########");
else if (value >= 1000 && value < 10000)) DecimalFormat formatter = new DecimalFormat("#.#######");

etc etc

textBox.setText(String.valueOf(formatter.format(value));