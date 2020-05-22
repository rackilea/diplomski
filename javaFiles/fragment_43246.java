ssize_t some_function(char *in, size_t in_sz) {
  if (in_sz < the_size_I_need) {
    return the_size_I_need; // query the size is pretty fast
  }

  // do some work on in if it's big enough

  // use negative sizes or exceptions to indicate errors

  return the_size_I_really_used; // send the real size back to Java
}