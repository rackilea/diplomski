@Override
public boolean equals(Object o) {
    if (o == this) {
        return true;
    }
    if (o == null) {
        return false;
    }
    if (!(o instanceof InitialMedicalCheckUpEntity)) {
        return false;
    }
    return this.getEmpId()==o.getEmpId();
}

@Override
public int hashCode() {
    return empId;
}