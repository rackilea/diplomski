WriteResult writeResult = collection.update(query1, update1, false, false);

    if ( writeResult.getN() == 0 ) {
        // Upsert would be tried if the array item was not found
        writeResult = collection.update(query2, update2, true, false);
    }