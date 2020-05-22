try {
   ...
   checksum = JacksumAPI.getChecksumInstance("whirlpool");
   ...
} catch(NoSuchAlgorithmException e) {
   //handle the exception
}