// reproducing your code
class A

    state=false;              //A
    initialized=false;        //B

    boolean state;
    volatile boolean initialized = false;        //0

    void setState(boolean newState)
        state = newState;                        //1
        initialized = true;                      //2

    boolean getState()
        if (!initialized)                        //3
            throw ...;
        return state;                            //4