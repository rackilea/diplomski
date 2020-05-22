@Override
public int compare(Integer i1, Integer i2) {
    long l1 = participants.get(i1).kpTime.get(kpSelected); 
    long l2 = participants.get(i2).kpTime.get(kpSelected);
    return Long.compare(l1, l2);
}