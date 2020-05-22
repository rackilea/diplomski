PreparedStatement ps=currentCon.prepareStatement("
            insert into availability (availableID,
                                      lecturerID,
                                      availableDay,
                                      availableStart,
                                      availableEnd,
                                      presentationid) 
           select availabilityseq.nextval,
                  ?,
                  presentationDay,
                  presentationStart,
                  presentationEnd,
                  presentationid
                  from presentation where presentationid=?
            ");  
            ps.setString(1,Abean.getLecturerID());  // match first "?"
            ps.setString(2,Abean.getPresentationID());    // match 2nd "?"