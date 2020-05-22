for(int i = 0; i < persons.size(); i++) {
     String [] info = /**Line From File Here As A String*/.split(";");
     persons[i].name = info[0];
     persons[i].age = info[1];
     persons[i].state = info[2];
}