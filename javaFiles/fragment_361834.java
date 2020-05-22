public int compare(Certificate o1, Certificate o2) {
  final int BEFORE = -1;
  final int AFTER = 1;

  /* To reverse the sorting order, multiple by -1 */
  if (o2 == null) {       // if o2 = null > o1 goes first
     return BEFORE * -1;  // -1 * -1 = 1 so o1 goes first
  }

  Comparable thisCertificate = o1.getName();  // get o1 name to compare
  Comparable thatCertificate = o2.getName();  // get o2 name to compare

  if(thisCertificate == null) {         // if o1 name is null, o2 goes first
     return AFTER * 1;                  // 1 * 1 = 1 > o1 goes first
  } else if(thatCertificate == null) {  // if o2 name is null, o1 goes first
     return BEFORE * -1;                // -1 * -1 = 1 > o1 goes first
  } else {                              
     // if both certs names are valid compare them in the usual way 
     //  sorting inversed because of the -1.
     return thisCertificate.compareTo(thatCertificate) * -1;
  }
}