/* Get int field 
     Take a look here, we are passing char* with 
     field descriptor - e.g. "I" => int 
*/

jfieldID fidInt = (*env)->GetFieldID (env, cls, "iVal", "I");
jint iVal = (*env)->GetIntField (env, objarg, fidInt);
printf ("iVal: %d\n", iVal);