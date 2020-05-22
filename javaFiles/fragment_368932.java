long[] scores = new long[csr.getCount];
    while (csr.moveToNext) {
        scores[csr.getPosition] = csr.getLong(csr.getColumnIndex("cdt_value");

    }
    csr.close();