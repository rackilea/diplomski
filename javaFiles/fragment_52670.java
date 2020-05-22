MQOD mqod  {MQOD_DEFAULT};
MQCONN...
mqod.ObjectType = MQOT_TOPIC;
mqod.Version    = MQOD_VERSION_4; /* To use ObjectString field */
mqod.ObjectString.VSPtr = argv[1];
mqod.ObjectString.VSLength = MQVS_NULL_TERMINATED;
MQOPEN(hConn,
       &mqod,
       MQOO_OUTPUT,
       &hObj,
       &CompCode, &Reason);
MQPUT....