Arrays.sort(appointments, new Comparator<Appointment>{

    @Override
    public int compare(Appointment appointment1, Appointment appointment2){
        return appointment1.getDate().compareTo(appointment2.getDate());
    }
});