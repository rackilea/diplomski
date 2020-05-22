SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 Date strDate = sdf.parse(my_date); 
 if (new Date().after(strDate))
 {
 your_date_is_outdated = true; 
 } 
 else
 {
 your_date_is_outdated = false; 
 }