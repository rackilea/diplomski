/* error checks omitted for brevity; these are *not* optional */

char *cBytes = /* ... */;
size_t numCBytes = /* ... */;
jbyteArray javaBytes = /* ... */;

jsize numBytes = (*env)->GetArrayLength(env, javaBytes);
jbyte *bytes = (*env)->GetPrimitiveArrayCritical(env, javaBytes, NULL);
/* It is pretty safe to assume that jbyte is a character type, such as signed
   char, in any C implementation that supports the JNI at all */
/* Assumes numCBytes <= numBytes; adjust as necessary if that may not be true: */
memcpy(bytes, cBytes, numCBytes);
(*env)->ReleasePrimitiveArrayCritical(env, javaBytes, bytes, 0);