...
        @Override
        public void handle(ActionEvent e) {
            primeList = new Label[10];
            for(int labelIdx=0; labelIdx<primeList.length; labelIdx++)
              primeList[labelIdx] = new Label();
            while (i < primeList.length) {
        ...