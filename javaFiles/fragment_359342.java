@Override
public int compareTo(Cita o) {
    int asc = getHoraInicio().compareTo(o.getHoraInicio());
    if (asc != 0) { return asc; }
    return o.getHoraTermino.compareTo(getHoraTermino())
}