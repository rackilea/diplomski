public void addData2(List<Appointment> newAppointments){
    Client client = new Client();
    client.setName("name1");
    entityManager.persist(client);
    for(Appointment a  : newAppointments)
        client.addAppointment(a);
    entityManager.merge(client);
    entityManager.close();
}