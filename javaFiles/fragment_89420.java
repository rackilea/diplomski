MY_ASSERT(vm_cached!=NULL);

JNIEnv* env;
jint res = vm_cached->AttachCurrentThread(&env,NULL);
MY_ASSERT(res==0);

jclass t2bClass = env->FindClass("local/ttt/Text2Bitmap");
MY_ASSERT(t2bClass!=NULL);

jmethodID getBitmap = env->GetStaticMethodID(t2bClass, "getBitmap","(Ljava/lang/String;I)Landroid/graphics/Bitmap;");
MY_ASSERT(getBitmap!=NULL);

jstring text = ...;
int fontsize = ...;
jobject bitmap = env->CallStaticObjectMethod(t2bClass, getBitmap, text, fontsize);
MY_ASSERT(bitmap!=NULL);

// process bitmap here
// ...

res=vm_cached->DetachCurrentThread();
MY_ASSERT(res==0);