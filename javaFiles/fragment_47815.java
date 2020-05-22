create.delete(CALENDAR)
      .where(CALENDAR.CLIENT_ID.in(
           select(CLIENT.ID)
          .from(CLIENT)
          .where(CLIENT.NAME.eq(listName))
      ))
      .execute();