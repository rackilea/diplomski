studentName=Singleton.getInstance().getNameId();

Log.v("studentname",""+studentName);

Iterator it=studentName.entrySet().iterator();

while (it.hasNext()) {

    Map.Entry entry = (Map.Entry) it.next();
    String name= String.valueOf(entry.getValue());
    students = new Students(); // Add this line 
    students.setName(name);

    list.add(students);

    Log.v("students",""+list);
}