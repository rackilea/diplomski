return db.query(DATABASETABLE, new String[] { 
                                   "_id", "invest_type", "curr_per_share_price",
                                   "share_name", "no_of_shares", 
                                   "share_identity", "purchase_price", 
                                   "purchase_from", "purchase_date", 
                                   "purchase_contact" 
               }, null, null, null,null, null);