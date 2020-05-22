private void updateRow(String visitorID, String[] data) {
    if (data.length > 5)
        throw new IllegalArgumentException("data[] is to long");
    for (int i = 0; i < dtm.getRowCount(); i++)
        if (dtm.getValueAt(i, 0).equals(visitorID))
            for (int j = 1; j < data.length+1; j++)
                dtm.setValueAt(data[j-1], i, j);
}