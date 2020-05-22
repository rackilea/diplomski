m_checkColumn.setFieldUpdater(

    new FieldUpdater<AIDataRecord, Boolean>() {
         @Override
         public void update(int index, AIDataRecord object, Boolean value) {
            object.toggleSelection();
            Window.alert("Nw : " + object.isSelected());
         }
    }

);