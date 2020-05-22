class virtualProduct {

  const time_t maxSync = 10;  // maximum age for unsynched d/b to row[]

  static struct {  // singleton
     int isActive;
     int urlRowId;
     etc ...
  } row [];

  static time_t lastSync;  // timestamp of last sync with d/b

  static mutex theLock;  // mutex to protect read/write of above


  function syncData()
  {
     lock (&theLock);

     // flush local updates to d/b
     foreach (row as item)
         if (item.updated)
         {
               sql_exec ("update products set whatever = " + value + " where rowId = " + whatever);
               if (okay)
                    item .updated = false;
         }

     // update from d/b (needed if other entities are updating it)
     sql_query ("select * from products");

     row [] = sql results;
     lastSync = now();
     unlock (&theLock);
  }

  function virtualProduct ()  // constructor
  {
      ...
      syncData();  // initialize memory copy of d/b
  }

  function ~virtualProduct ()  // destructor
  {
      syncData();  // write last updates
      ...
  }

  function UpdateItem(int id)
  {
     lock (&theLock);
     if (now () - lastSync > maxSync)
         syncData();
     int index = row.find (id);
     if (index >= 0)
     {
         row [index] .fields = whatever;
         row [index] .isActive = 0;
     }
     unlock (&theLock);
  }

  function ObtainNextItem()
  {
     lock (&theLock);
     if (now () - lastSync > maxSync)
         syncData();
     result = null;
     foreach (row as item)
         if (item.isActive == 1)
         {
              item.isActive = 2;  // using Peter Schuetze's suggestion
              result = item.id;
              break;
         }
     unlock (&theLock);
     return result;
  }
}