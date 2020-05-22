prototypeStorageObj = $T("itemZone");
    zoneManager = prototypeStorageObj.zoneManager;
    // jquery stuff that kills the prototype data storage.
    emailForm = $J("#myDialog");
    emailForm.dialog({ autoOpen: false, modal:true });
    emailForm.dialog('open');
    // restore the zone manager so the zone works again:
    $T("itemZone").zoneManager = zoneManager;