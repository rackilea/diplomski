for (i = 0; i < nPersons; i++) {
    String varname = "personName_" + (i + 1);
    cvWriteString(fileStorage, // fs
                  varname, // name
                  (String) personNames.get(i), // string
                  0); // quote
}