pmList.add(
       sdfFormat.format(  <-- Gives a string 23/06/2014 01:50:00
            sdfClient.parse( <-- Gives a Date corresponding to the time 20140623135000.0
                  pmData[k].retrievalTime   <-- Time 20140623135000.0
               )
        )
        );