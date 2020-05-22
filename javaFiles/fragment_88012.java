mid = (*env)->GetStaticMethodID(env, cls, "newPerson", "(ILjava/lang/String;)LPerson;");
mod_obj = mid;
if (mid) {
    person = (*env)->CallStaticObjectMethod(env, cls, mid, 23, "Nox");
    cls2 = (*env)->FindClass(env, "Person");
    mid = (*env)->GetMethodID(env, cls2, "getAge", "()I");
    jint age = (*env)->CallIntMethod(env, mid_obj, mid, NULL);
    printf("age: %i\n", age);
}