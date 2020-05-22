public class GetSize extends VarArgFunction {

private Dimension size;

public GetSize(Dimension size) {

    this.size= size;

}

public Varargs invoke(Varargs v) {

    Varargs varargs = LuaValue.varargsOf(new LuaValue[] {LuaValue.valueOf(size.width), 
            LuaValue.valueOf(size.height)});

    return varargs;

}

}