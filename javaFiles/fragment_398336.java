ctx.insertInto(TABLE_BRIDGE)
   .columns(TABLE_BRIDGE.TABLE_A_ID, TABLE_BRIDGE.TABLE_B_ID)
   .values(
        ctx.insertInto(TABLE_A)
           .columns(TABLE_A.VAL)
           .values(aVal)
           .returning(TABLE_A.ID)
           .fetchOne()
           .get(TABLE_A.ID),
        ctx.insertInto(TABLE_B)
           .columns(TABLE_B.VAL)
           .values(bVal)
           .returning(TABLE_B.ID)
           .fetchOne()
           .get(TABLE_B.ID)
   )
   .execute();