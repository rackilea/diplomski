public function addData1(){
    EntityManager em = EMF.get().createEntityManager();
    Client client = new Client(name);
    for(Appointment a  : newAppointments)
        client.addAppointment(a);
    em.persist(client);
    em.close();
}