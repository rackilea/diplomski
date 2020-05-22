@Override
    public void insertUpdate(DocumentEvent e) {
        fieldList.put(field,getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        fieldList.put(field,getText());
    }