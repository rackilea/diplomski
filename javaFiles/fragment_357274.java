package foundations.of.computing;

/**
 *
 * @author Kayotic
 */
class DFA_State {
    private final String state;
    private final DFA_State on_0;
    private final DFA_State on_1;
    private final boolean isAccepting;
    //private DFA_State dummy;

    public DFA_State(DFA_State arg) {
        //this(arg.is_accepting(), arg.on0(), arg.on1());
        state = arg.get_name();
        isAccepting = arg.is_accepting();
        on_0 = arg.on0();
        on_1 = arg.on1();
    }

    public DFA_State(String name, Boolean accepting, DFA_State on0, DFA_State on1) {
        state = name;
        isAccepting = accepting;
        on_0 = on0;
        on_1 = on1;
    }

    public String get_name(){
        return state;
    }


    public Boolean is_accepting() {
        return isAccepting;
    }

    public DFA_State on0() {
        return on_0;
    }

    public DFA_State on1() {
        return on_1;
    }

    public DFA_State nextState(char i) {
        if (i == '0') {
            return on0();
        } else if (i == '1') {
            return on1();
        } else {
            System.out.println("Error with input");
            return null;
        }
    }
}