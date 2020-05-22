ExecutorService ex = Executors.newSingleThreadExecutor(r ->{
        Thread t = Executors.defaultThreadFactory().newThread(r);
        t.setDaemon(true);
        return t;
    });

    ex.execute(()-> {
    int i = 0;
    for (Input x : inputList) {
        int index= i;

        //must be declareid here because of lambda rules
        //or put in a container that is effectively final
        Int id = dataDownloader.downloadID(x.getProducer_code());
        writer.print(x.getProduct_code() + ';');
        writer.print("0;");
        writer.print(producentChoiceBox.getSelectionModel().getSelectedItem().toString().toUpperCase() + ";");
        writer.print(x.getProducer_code() + ";");
        writer.print(x.getName() + ";");
        writer.print("Import - bez kategorii;");
        writer.print("4.6;");
        writer.print("20;");
        writeImages(id);
        Platform.runLater(()->{
           logBookTextArea.appendText("Czytam " +index+" );
           logBookTextArea.appendText("OK");
           logBookTextArea.appendText("\n");

        });
        I++
    }
});