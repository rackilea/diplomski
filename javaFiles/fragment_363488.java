JNIEXPORT jobjectArray JNICALL myMethod(JNIEnv *env, jclass, //parameters){

    int** result = //my function to obtain a matrix n x m of integers
    std::vector<jint> tmp;

    //fill the vector tmp with matrix integers and deallocate the matrix
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            tmp[m*i + j] = result[i][j];
        }
        free(result[i]);
    }
    free(result);

    jintArray jResults = env->NewIntArray( tmp.size() );
    env->SetIntArrayRegion( jResults, 0, tmp.size(), &tmp[0] );
    return env->NewObjectArray(tmp.size(), env->GetObjectClass(jResults), 0);
}