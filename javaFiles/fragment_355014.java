ListView myListView = new ListView(getApplicationContext());

List<Person> personList = new ArrayList<>();

Person person = new Person();

person.setName("John");
person.setSurname("Doe");
person.setImageUrl("https://lh3.googleusercontent.com/-Sa9kdnhuE5E/AAAAAAAAAAI/AAAAAAAAABs/ILmJ8_sk9aY/photo.jpg");

 MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.person_cell, personList);

myListView.setAdapter(adapter);