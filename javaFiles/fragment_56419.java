for(i = 0; i < rows; i++)
{
    jobjectArray currentRow = (jobjectArray)((env->GetObjectArrayElement(jfilePaths, i));
    for(j = 0; j < columns; j++)
    {
        jstring filePath = (jstring)((env->GetObjectArrayElement(currentRow, j));
        const char *rawString = env->GetStringUTFChars(filePath, 0);

        // do stuff...
    }
}