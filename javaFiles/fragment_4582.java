// Grab Fields
jclass cls = env->GetObjectClass(obj);
jfieldID fid = env->GetFieldID(cls, "testField", "[I");

jintArray jary;
jary = (jintArray)env->GetObjectField(obj, fid);
jint *body = env->GetIntArrayElements(jary, 0);
body[0] = 3000;
env->ReleaseIntArrayElements(jary, body, 0);