private float absDifference(float[] vector1, float[] vector2) {
    float difference=0;
    int len=Math.min(vector1.length, vector2.length);
    for(int n=0;n<len;n++){
            diff+=vector1[n]-vector2[n];
        difference+=Math.abs(vector1[n]-vector2[n]);
    }
    if(vector1.length > vector2.length){
        for(;n<vector1.length;n++){
            difference+=Math.abs(vector1[n]);
       }
    }else{
       for(;n<vector2.length;n++){
           difference+=Math.abs(vector2[n]);
       }
    }
    return difference;
}