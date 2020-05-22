// retrieve the java.util.List interface class
jclass cList = env->FindClass("java/util/List");

// retrieve the size and the get method
jmethodID mSize = env->GetMethodID(cList, "size", "()I");
jmethodID mGet = env->GetMethodID(cList, "get", "(I)Ljava/lang/Object;");

if(mSize == NULL || mGet == NULL)
    return -1;

// get the size of the list
jint size = env->CallIntMethod(jList, mSize);
std::vector<std::string> sVector;

// walk through and fill the vector
for(jint i=0;i<size;i++) {
    jstring strObj = (jstring)env->CallObjectMethod(jList, mGet, i);
    const char * chr = env->GetStringUTFChars(strObj, NULL);
    sVector.push_back(chr);
    env->ReleaseStringUTFChars(strObj, chr);
}

// print the vector
for(int i=0;i<sVector.size();i++) {
    std::cout << sVector[i] << std::endl;
}