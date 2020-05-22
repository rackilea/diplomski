jboolean isCopy; 
jfloat *_arr = env->GetFloatArrayElements(arr, &isCopy);

// if isCopy==JNI_FALSE you work directelyon the original Java data
// if it's JNI_TRUE, you work on a temporary copy

... // do your stuff, supposing that you want all changes to _arr[] reflected
    // in the original Java array

env->ReleaseFloatArrayElements(arr, _arr, JNI_COMMIT); // copy back 
// nota: if isCopy was JNI_TRUE you could opt for JNI_ABORT to cancel changes
// but this is ignored if you did your chang eon the original daa