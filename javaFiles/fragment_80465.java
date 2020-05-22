final String line = bufferedReader.relineadLine();
// final+local var so usable in Runnable.

SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        input.append(line + "\n");
    }
}