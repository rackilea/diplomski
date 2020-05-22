class Super { }

interface Cool { boolean isCool(); }

class CoolImpl extends Super implements Cool {
    private boolean cool;
    public CoolImpl(boolean cool) { this.cool = cool; }
    public boolean isCool() { return this.cool; }
}

class Sub1 extends CoolImpl { }
class Sub2 extends CoolImpl { }    
class Sub3 extends Super { }

class CoolList extends ArrayList<Cool> {
    public boolean add(Cool cool) {
        if (!cool.isCool()) {
            return false;
        }
        return super.add(cool);
    }
}