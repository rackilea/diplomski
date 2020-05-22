Stack<YourClassOfTheCheckModel> recentlyUnchcked = new Stack<YourClassOfTheCheckModel>();
yourTreeView.getSelectionModel().
selectedItemProperty().addListener( new ChangeListener() {

        @Override
        public void changed(ObservableValue observable, Object oldValue,
                Object newValue) {

            TreeItem<YourClassOfTheCheckModel> selectedItem = 
               (TreeItem<YourClassOfTheCheckModel>) newValue;
           CheckModel checkModel = checkTreeView.getCheckModel().
           bool checked = checkModel.isChecked (selectedItem);
           if(checked==false){
                recentlyUnchcked.push(yourObjectOfTheCheckModel);
           }
        }

      });