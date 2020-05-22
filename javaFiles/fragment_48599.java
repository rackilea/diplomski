public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof Appointment)) return false;
Appointment that = (Appointment) o;
return id.equals(that.id);
}