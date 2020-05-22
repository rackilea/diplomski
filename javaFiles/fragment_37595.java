public void run() {
    try{
        while (!isDone) {
            System.out.println("Running!!");
            System.out.println();
            DataHelper.setCurrentDate(LocalDate.now());
            if (!DataHelper.getOldDate().equals(DataHelper.getCurrentDate())) {
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        DataHelper.setIntIndex(DataHelper.getIntIndex()+1);
                    }
                });
                DataHelper.setOldDate(DataHelper.getCurrentDate());
                DataHelper.saveData();
                System.out.println("Saved!");
            }