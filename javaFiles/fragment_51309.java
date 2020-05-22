public class main {
    // Initalize context
    Context mContext;

    public main(){
    }

    public main(Context mContext){
        this.mContext = mContext;
    }
    public boolean main() {
       Log.d("MYLOG", "main() called successfully when there context is not initialized like above");
        // some code here  
    }
}