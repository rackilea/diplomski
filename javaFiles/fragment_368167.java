import com.googlecode.javacpp.*;
import com.googlecode.javacpp.annotation.*;

@Platform(include="items.h")
public class Items {
    static { Loader.load(); }

    public static class Item extends Pointer {
        public Item() { allocate(); }
        private native void allocate();

        public native int id();           public native Item id(int id);
        @Cast("const char*")
        public native BytePointer name(); public native Item name(BytePointer name);
    }

    public static class Items_Callback extends FunctionPointer {
        protected Items_Callback() { allocate(); }
        private native void allocate();

        public native int call(@Const Item item, Pointer context);
    }

    public static class Items_Call extends Pointer {
        public Items_Call() { allocate(); }
        private native void allocate();

        public native int value();               public native Items_Call value(int value);
        public native Pointer context();         public native Items_Call context(Pointer context);
        public native Items_Callback callback(); public native Items_Call callback(Items_Callback value);

        public void setInterface(Items_Callback i) { callback(i); }
    }

    public static native void Items_create(Item item, Items_Call call);

    public static void main(String[] args) {
        BytePointer s = new BytePointer("Hello");
        Item i = new Item();
        i.id(42);
        i.name(s);

        Items_Callback cb = new Items_Callback() { 
            public int call(Item item, Pointer context) {
                System.out.println(item.id() + " " + item.name().getString());
                return 0;
            }
        };
        Items_Call ic = new Items_Call();
        ic.callback(cb);

        Items_create(i, ic);

        // if we remove these references, the GC may prematurely deallocate them
        s.deallocate();
        cb.deallocate();
    }
}