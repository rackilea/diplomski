interface ServerToClientPacket { 
    void performAction(Client c); 
}

class MyMessage implements ServerToClientPacket {
    String message;
    MyMessage(String message) { this.message = message; }
    void performAction(Client c) {
        JOptionPane.showMessageDialog(message);
    }
}

class PersonList implements ServerToClientPacket {
    LinkedList<Person> people;
    // constructor here
    void performAction(Client c) {
        for(Person person : people) {
            c.pts.println(person);
        }
    }
}