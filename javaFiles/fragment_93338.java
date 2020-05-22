android_main(struct *android_app){
    JNIEnv *env = android_app->activity->env;
    jclass build_class = FindClass(env, "android.os.Build");
    jfieldID brand_id = GetStaticFieldID(env, build_class, "BRAND", "Ljava/lang/String;");
    jstring brand_obj = (jstring)GetStaticObjectField(env, brand_id);
}