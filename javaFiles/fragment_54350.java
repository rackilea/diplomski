abstract class Slot<T extends Slot<T>> {
    public Slot(Manager<T> m) {

    }
}

class SlotA extends Slot<SlotA> {

    public SlotA(Manager<SlotA> m) { //a constructor with Manager<SlotA> is not required!
        super(m);
    }
}

class SlotB extends Slot<SlotB> {

    public SlotB(Manager<SlotB> m) { //a constructor with Manager<SlotB> is not required!
        super(m);
    }
}