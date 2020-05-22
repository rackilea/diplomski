Note note1 = new Note();
note1.setContent("my first note");
Note note2 = new Note();
note2.setContent("my second note");
User user = new User();
user.setName("Andrei");
user.addNote(note1);
user.addNote(note2);
session.save(user);