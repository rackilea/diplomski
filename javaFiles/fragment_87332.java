listView.setCellFactory(new Callback<ListView<Participant>, 
    ListCell<Participant>>() {

        @Override
        public ListCell<Participant> call(ListView<Participant> param) {
            ListCell<Participant> cell = new ListCell<Participant>() {

                @Override
                protected void updateItem(Participant item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item.getId() + ": " + item.getName() + " " + item.etc());
                    } else {
                        setText("");
                    }
                }
            };
            return cell;
        }
    });