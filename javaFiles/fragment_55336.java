ResultSet rs = st.executeQuery("select s.folderEntry,p.id,p.title, "+
  "max(case when s.name = 'event_types' then s.stringValue end) as Event_Type, "+
  "max(case when s.name = 'attendees_no' then s.stringValue end) as No_of_Attendee, "+
  "max(case when s.name = 'booker' then s.stringValue end) as Booker, "+
"max(case when s.name = 'startdate' then s.stringValue end) as Start_date, "+
"max(case when s.name = 'starttime' then s.stringValue end) as Start_time, "+
"max(case when s.name = 'enddate' then s.stringValue end) as End_date, "+
"max(case when s.name = 'endtime' then s.stringValue end) as End_time, "+
"max(case when s.name = 'actual_attendees_no' then s.stringValue end) as Actual_Attendees_No, "+
"max(case when s.name = 'edb' then s.stringValue end) as EDB, "+
"max(case when s.name = 'ss_teacher' then s.stringValue end) as Secondary_School_teacher, "+
"CONCAT(p.description_text, '<br>') "+
"from sitescape.ss_folderentries "+
"p join sitescape.ss_customattributes s on p.id = s.folderEntry "+
"group by "+
 "p.id, "+
  "s.folderEntry");