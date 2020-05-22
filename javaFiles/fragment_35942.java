private void outputText(final String outputString) {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            // Find the TextView
            TextView output = (TextView)findViewById(R.id.ConsoleOutputView);
            // Display the output
            Log.i("TextOutput","About to display message: " + outputString);
            output.setText(Output.getText() + outputString);
            Log.i("TextOutput","Message displayed");
        }
    });
}