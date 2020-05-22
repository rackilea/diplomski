final Label textDisplayLabel = new Label();

        @Override
        public void handle(ActionEvent event) {                
                textDisplayLabel.setText(calcTime.getTimestampDiff(new DateTime(1976, 9, 11, 10, 59, 0, 0), new DateTime(2012, 11, 11, 10, 59, 0, 0))); 
            }
        });