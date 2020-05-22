public void actionPerformed(ActionEvent ev) {

    new SwingWorker<Void, String>() {
        @Override // this method is done in the Worker Thread
        protected Void doInBackground() throws Exception {
            while(true){ 
                String res = checkQuote(text.getText());
                publish(res); //will call the process method
                Thread.sleep(1000 * 60 * 60); //1 hour
            }
        }

        @Override // this method is done in the EDT
        protected void process(List<String> resultList){
            String res = resultList.get(0);

            if(!"".equals(res)){
                result.setText(res);
            }
        }

        @Override // this method is done in the EDT. Executed after executing the doInBackground() method
        protected void done() {
            //... clean up
        }
    }.execute();
}