List<Foo> list = new ArrayList<>();
//fill list with your foo instances


Set<Date> uniqueDates = new HashSet<>();
List<Foo> resultList = new ArrayList<>();

for (Foo f : list){
    if (uniqueDates.add(f.getDate())){//if I was able to add date to set
        //it means that instance with this date is seen first time
        //so I can add it to result list
        resultList.add(f);
    }
}