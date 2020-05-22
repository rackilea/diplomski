enum AppointmentType {General, Review, Weekly};

ObservableList<Appointment> Appointments = appointmentDOA.findAll();

Map<AppointmentType, Long> appointmentsMap = appointments.stream()
            .collect(Collectors.groupingBy(Appointment::getType, Collectors.counting()));