MQSD mqsd  {MQSD_DEFAULT};
MQCONN...
mqsd.Options = MQSO_CREATE | MQSO_NON_DURABLE | MQSO_MANAGED;
mqsd.ObjectString.VSPtr = argv[1];
mqsd.ObjectString.VSLength = MQVS_NULL_TERMINATED;
MQSUB(hConn,
      &mqsd,
      &hObj,
      &hSub,
      &CompCode, &Reason);
MQGET from hObj...