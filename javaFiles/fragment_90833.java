CTPageSz pageSize;
    if (section.isSetPgSz()) {
       pageSize = section.getPgSz();
    } else {
       pageSize = section.addNewPgSz();
    }