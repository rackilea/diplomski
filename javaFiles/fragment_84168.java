session = Db.getSession(); 
Transaction tx = null; 
try { 
    tx = session.beginTransaction(); 
    License license = getLicense(session, licenseStr); 
    List<MacAddress> macAddresses = license.getMacAddresses(); 
    for(MacAddress mac:macAddresses) 
    { 
        if(mac.getMacAddress().equals(macAddress)) 
        { 
            return; 
        } 
    } 

    MacAddress mac = new MacAddress(); 
    mac.setMacAddress(macAddress); 
    license.getMacAddresses().add(mac);     
    tx.commit(); 
} catch (RuntimeException e) { 
    if (tx != null) tx.rollback(); 
    throw e; // or display error message 
} finally { 
    session.close(); 
}