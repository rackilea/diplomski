final FileCharacterStream stream = new FileCharacterStream(db);

    Dataholder[] args = new Dataholder[]{new Dataholder("xml")};
    Dataholder res = ((SysDatabase) db).runClassMethod("%File", "TempFilename", args, 0);
    stream._filenameSet(res.getString());

    loadContent(stream, path);

    final String remoteFileName = stream._filenameGet();


    /*
     * Arguments for class "%SYSTEM.OBJ", class method "Load"
     */
    final Dataholder[] arguments = new Dataholder[9];

    /*
     * Arguments ByRef
     *
     * Indices start at 1, not 0
     */
    final int[] byRefArgs = new int[3];

    // Arg 3: error log
    final StringHolder errorlog = new StringHolder("");
    byRefArgs[0] = 3;

    // Arg 4: list of loaded items
    final StringHolder loadedlist = new StringHolder("");
    byRefArgs[1] = 4;

    // Arg 9: description (?)
    final StringHolder description = new StringHolder("");
    byRefArgs[2] = 9;

    /*
     * Fill arguments
     */
    // arg 1: file name
    arguments[0] = Dataholder.create(remoteFileName);
    // arg 2: qspec; we want to ensure that compile works, at least
    arguments[1] = new Dataholder("d");
    // arg 3: errorlog
    arguments[2] = Dataholder.create(errorlog.value);
    // arg 4: loadedlist
    arguments[3] = Dataholder.create(loadedlist.value);
    // arg 5: listonly; no
    arguments[4] = Dataholder.create(Boolean.FALSE);
    // arg 6: selecteditems; nothing
    arguments[5] = Dataholder.create(null);
    // arg 7: displayname. For logging...
    arguments[6] = Dataholder.create("IMPORT.xml");
    // arg 8: charset. Default is empty string, we'll assume UTF-8.
    arguments[7] = new Dataholder((String) null);
    // arg 9: description (?)
    arguments[8] = Dataholder.create(description.value);

    // Now, make the call
    final Dataholder[] result = db.runClassMethod(
        "%SYSTEM.OBJ",
        "Load",
        byRefArgs,
        arguments,
        Database.RET_PRIM
    );

    /*
     * The result normally has three members:
     *
     * - first is the status; and we need to do that:
     */
    db.parseStatus(result[0]);

    /*
     * - others are ByRef arguments
     */
    errorlog.set(result[1].getString());
    System.out.println("errorlog: " + errorlog.getValue());

    loadedlist.set(result[2].getString());
    System.out.println("loadedlist: " + loadedlist.getValue());