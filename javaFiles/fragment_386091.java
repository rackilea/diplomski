// This doesn't work.
public function addData2(){
    EntityManager em = EMF.get().createEntityManager();
    Client client = new Client(name);
    em.persist(client);
    em.close();    <--- You persist client with no appointment
    for(Appointment a  : newAppointments)
        client.addAppointment(a);   <-- those entitys are detached entity ( not persisted)
}