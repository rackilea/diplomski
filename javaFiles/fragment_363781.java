if (device.getSerialNumber() != null && device.getSerialNumber().trim().length > 0 
     && device.getIpAddress() != null && device.getIpAddress().trim().length > 0 ) {
        criteria.add(Restrictions.or(
              Restrictions.like("serialNumber", device.getSerialNumber()),
              Restrictions.like("ipAdress", device.getIpAdress()));
} else if (device.getIpAddress() != null && device.getIpAddress().trim().length > 0 ) {
    criteria.add(Restrictions.like("ipAdress", device.getIpAdress()));
} else if (device.getSerialNumber() != null && device.getSerialNumber().trim().length > 0 ) {
  criteria.add(Restrictions.like("serialNumber", device.getSerialNumber()));
 }