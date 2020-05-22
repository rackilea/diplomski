// incorrect:

HyperonDomainObject lob = engine.getDomain("GROUP", "LOB[GROUP]");
HyperonDomainObject trm = lob.getChild("PRODUCT", "PRD3");
HyperonDomainObject adb = trm.getChild("RIDER", "ADB");

// adb is domain element snapshot

while (true) {

    log.info("code = {}", adb.getAttrString("CODE", ctx));

    // sleep 3 sec
    ...
}


// == console ==   (in meantime user changes attribute CODE from "A" to "BBB")
// but adb is frozen - it is snapshot

code = A
code = A
code = A
code = A
...