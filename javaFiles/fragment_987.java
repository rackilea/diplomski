addToChat("You: "+enter.getText());
enter.setText("");
new Thread(
    new Runnable() {
        public void run() {
            delay(1000);
            addToChat("oie");
        }
    }
).start();