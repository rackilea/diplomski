jclass javaLangByteClass = env->FindClass("java/lang/Byte");
jmethodID javaLangByteStaticValueOf = env->GetStaticMethodID(javaLangByteClass , "valueOf", "(B)Ljava/lang/Byte;")
for (int i=0; i<3; i++) {
   jobject nextElement = env->CallStaticObjectMethod(javaLangByteClass, javaLangByteStaticValueOf, (jbyte)tempSim[i]);
   env->SetObjectArrayElement(sim, i, nextElement);
   env->DeleteLocalRef(nextElement);
}