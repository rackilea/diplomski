"filter": {
    "script": {
        "script": { 
            "inline": "long t1 = new Date().getTime(); 
                       long t2 = doc['PostCodeDate'].value.getMillis(); 
                       t1 -= t1 % (24 * 3600 * 1000); 
                       t2 -= t2 % (24 * 3600 * 1000);
                       return (t1 - t2) / (24 * 3600 * 1000) == params.missDelby",
             "params": { "missDelby": 1 }
         }
     }
}