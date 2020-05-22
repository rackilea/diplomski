final ListCell<Client> cell = new ListCell<Client>(){
          @Override
            public void updateItem(Client item, boolean empty){
              super.updateItem(item,empty);
              if(item != null){
                  leadLbl.setText(item.getFirstname());
                  setText(item.getFirstname()+" "+item.getLastname());
                  tooltip.setText(item.getFirstname());
                  setTooltip(tooltip);
              }
              else {
                  leadLbl.setText("");
                  setText("");
              }
          }
        };