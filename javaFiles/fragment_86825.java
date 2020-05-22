enum Paths {
STYLE_SHEETS("../stylesheets"),
CONTROLLER("../controller"),
CONNECTION("../connection"),
RESOURCE("../resource"),
VIEWS("../views"),
APPLICATION("../application"),
MOVE_UP("..");

private final String path;

private Paths(final String value) {
    this.path = value;
}

@Override
public String toString() {
    return path;
}
}
public class test{
    public static void main(String[] args){
        System.out.println(Paths.MOVE_UP.toString() + Paths.VIEWS.toString());
}
}