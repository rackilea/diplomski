while (cachedRowSet.next()) {
        for (int i = 0; i < columnCount; i++) {

                dataHandler.updateRowSetData(cachedRowSet, i + 1, columnTypes[i], getUpdatedData());
                cachedRowSet.updateRow(); //Adding this line solves the problem. Otherwise changes are not made

        }
    }