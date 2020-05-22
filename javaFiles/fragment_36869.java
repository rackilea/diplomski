...
    id++;
    cttable.setRef(my_data_range.formatAsString());
    cttable.setDisplayName(wantedDisplayName);      /* this is the display name of the table */
    cttable.setName(wantedDisplayName);    /* This maps to "displayName" attribute in <table>, OOXML */
    cttable.setId(id); //id attribute against table as long value
    cttable.addNewAutoFilter();
...