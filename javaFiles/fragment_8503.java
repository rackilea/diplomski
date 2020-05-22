DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:m a");

sb.append(appointment.getPatientId())
   .append(";")
   .append(appointment.getStartTime().format(formatter))
   .append(";")
   .append(appointment.getEndTime().format(formatter))
   .append(";")
   .append(appointment.getDoctor().getName());