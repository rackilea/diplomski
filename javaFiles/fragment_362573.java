private PrintService printer = ...; // init this using PrintService.lookupPrintServices();

if(this.printer != null) {
        String commandToSend = "Some command\n";

        Doc myDoc = new SimpleDoc(commandToSend.getBytes(), DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
        DocPrintJob job = this.printer.createPrintJob();

        try {
            job.print(myDoc, null);
        } catch (PrintException e) {
            e.printStackTrace();
        }
    }