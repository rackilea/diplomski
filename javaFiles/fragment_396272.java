public class MsgLog<T,U> {

    private boolean sentOk ;
    private U theMsg ;

    private MsgLog(T sentOkp, U theMsg)
    {

        this.sentOk = sentOkp ; // compile error - assignment to incompatible type
        this.theMsg = theMsg ;
    }

}