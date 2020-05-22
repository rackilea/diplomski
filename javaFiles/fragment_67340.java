DateTimeFormatter sdf = DateTimeFormat.forPattern("dd/MM/yyyy");//formatter for display
LocalDate start = new LocalDate(2015, 01, 01);
LocalDate end = new LocalDate(2015, 06, 01);
List<Dates> revised = new ArrayList<Dates>(); //populated array
List<Dates> datesinDB = new ArrayList<Dates>(); //
int count = 1; //index for arrays
datesinDB.add(new Dates(new LocalDate(2015,02,15), 1)); //data
datesinDB.add(new Dates(new LocalDate(2015,02,16), 2));
datesinDB.add(new Dates(new LocalDate(2015,02,17),22));
datesinDB.add(new Dates(new LocalDate(2015,02,19),14));

LocalDate c = datesinDB.get(count-1).getDate(); //initial data
int values = datesinDB.get(count-1).getValue(); //initial data

for(int i = start.getDayOfYear(); i <=end.getDayOfYear() ; i++){
    if(i == c.getDayOfYear())
    {
        if(count < datesinDB.size()){
            revised.add(new Dates(c, values));
            c = datesinDB.get(count).getDate();
            values = datesinDB.get(count++).getValue();
        }
        else if(count == datesinDB.size()){
            revised.add(new Dates(c, values));
            count++;
        }
    }
        else
        {
            if(i != 59){//some issues with 28/2/2015 due to leap year i guess
                revised.add(new Dates(new      LocalDate().withDayOfYear(i).withYear(2015), 0));
           }
        }
   }

    System.out.println("Date      | Values");
    for(int i = 0; i< revised.size(); i++){
        System.out.println(sdf.print(revised.get(i).getDate())+ " | "+ revised.get(i).getValue());
    }