TableARecord a = ctx.newRecord(TABLE_A);
a.setVal(aVal);
a.store();

TableBRecord b = ctx.newRecord(TABLE_B);
b.setVal(bVal);
b.store();

TableBridgeRecord bridge = ctx.newRecord(TABLE_BRIDGE);
bridge.setTableAId(a.getId());
bridge.setTableBId(b.getId());
bridge.store();