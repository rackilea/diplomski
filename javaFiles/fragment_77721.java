StringBuilder builder = new StringBuilder()
try {
    while ((s = stdInput.readLine()) != null) {
        builder.append('\n').append(s);
    }

    while ((s = stdError.readLine()) != null) {
        builder.append('\n').append(s);
    }

    textArea.setText(builder.toString();
} catch (IOException e2) {
    e2.printStackTrace();
}