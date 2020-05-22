bool os::dll_build_name(char* buffer, size_t buflen,
                        const char* pname, const char* fname) {
  bool retval = false;
  // Copied from libhpi
  const size_t pnamelen = pname ? strlen(pname) : 0;

  // Return error on buffer overflow.
  if (pnamelen + strlen(fname) + 10 > (size_t) buflen) {
    return retval;
  }

  if (pnamelen == 0) {
    snprintf(buffer, buflen, "lib%s.so", fname);
    retval = true;
  } else [...]