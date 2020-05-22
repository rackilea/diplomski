public Cursor readEntry(String name) {

           return database.rawQuery("SELECT i.Weather, i.Date, i.Status, w.SubContractors, w.NumberOfPerson, w.NumberOfHours, 
wd.Project, wd.WorkDescription FROM Information i LEFT JOIN WorkForce w 
ON w.TInfo_id = i.ID LEFT JOIN WorkDetails wd ON wd.Twf_id = w.ID WHERE
 i.Name = ?",new String[] {String.valueOf(name)},null);

        }