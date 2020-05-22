// retrieve the java.util.List interface class
jclass cList = env->FindClass("java/util/List");

// retrieve the toArray method and invoke it
jmethodID mToArray = env->GetMethodID(cList, "toArray", "()[Ljava/lang/Object;");
if(mToArray == NULL)
    return -1;
jobjectArray array = (jobjectArray)env->CallObjectMethod(jList, mToArray);

// now create the string array
std::string* sArray = new std::string[env->GetArrayLength(array)];
for(int i=0;i<env->GetArrayLength(array);i++) {
    // retrieve the chars of the entry strings and assign them to the array!
    jstring strObj = (jstring)env->GetObjectArrayElement(array, i);
    const char * chr = env->GetStringUTFChars(strObj, NULL);
    sArray[i].append(chr);
    env->ReleaseStringUTFChars(strObj, chr);
}

// just print the array to std::cout
for(int i=0;i<env->GetArrayLength(array);i++) {
    std::cout << sArray[i] << std::endl;
}