jclass javaLangByteClass = env->FindClass("java/lang/Byte");
jmethodID javaLangByteConstructor = env->GetMethodID(javaLangByteClass , "<init>", "(B)Ljava/lang/Byte;")
for (int i=0; i<3; i++) {
   jobject nextElement = env->NewObject(javaLangByteClass, javaLangByteConstructor, (jbyte)tempSim[i]);
   env->SetObjectArrayElement(sim, i, nextElement);
   env->DeleteLocalRef(nextElement);
}