Comparator<Zone> byName = (z1, z2)->{
    if(z1.getZoneName().toLowerCase().equals(z2.getZoneName().toLowerCase()))
       return z1.getZoneName().compareTo(z2.getZoneName());
    else
       return z1.getZoneName().toLowerCase().compareTo(z2.getZoneName().toLowerCase());
};