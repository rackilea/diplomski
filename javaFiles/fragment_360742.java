...

MainInterFace object = new MainInterFace(){

       CallBackInterface callback;

       public void registerCallBackInterFace(CallBackInterface callBacks){
            this.callback = callbacks;
       }

       public void getResultFromFaceBook(){
           /* write your code for faceBook here */
           int result = 10;    //eg for returning a value
           callback.getInt(result);
       }
};
...