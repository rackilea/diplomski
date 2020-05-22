public static void main(String[] args) throws InterruptedException {
    String typeName = "Boolean";
    String memberValue = "memberValue";
    SwitchInputType type = Type.valueOf(typeName).makeType(memberValue);
}

enum Type {
    Boolean {
        SwitchInputType makeType(String memberValue) {
            return new SwitchInputType<Boolean>(new Boolean(memberValue));
        }
    },
    Double {
        SwitchInputType makeType(String memberValue) {
            return new SwitchInputType<Double>(new Double(memberValue));
        }
    }, 
    Int32 {
        SwitchInputType makeType(String memberValue) {
            return new SwitchInputType<Integer>(new Integer(memberValue));
        }
    };

    // All must do this.
    abstract SwitchInputType makeType(String memberValue);
}

static class SwitchInputType<T> {
    public SwitchInputType(Object o) {
    }
}