private Date d;

Date getDate() {
  // Return a reference to an independent copy of the original data
  return new Date(d.getTime());
}

void setDate(Date inD) {
    // Checks for inD 
    d = inD;
}