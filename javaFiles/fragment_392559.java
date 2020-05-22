jboolean isCopy;
void *data = env->GetPrimitiveArrayCritical((jarray)bArray, &isCopy);

memcpy(data, buf, bytecount);

// and don't forget the 'release'