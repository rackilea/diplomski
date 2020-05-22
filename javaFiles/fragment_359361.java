while (true) {

    HyperonDomainObject lob = engine.getDomain("GROUP", "LOB[GROUP]");
    HyperonDomainObject trm = lob.getChild("PRODUCT", "PRD3");
    HyperonDomainObject adb = trm.getChild("RIDER", "ADB");

    log.info("code = {}", adb.getAttrString("CODE", ctx));

    // sleep 3 sec
    ...
}


// == console ==   (in meantime user changes attribute CODE from "A" to "BBB")
// adb is always fresh

code = A
code = A
code = BBB
code = BBB
...