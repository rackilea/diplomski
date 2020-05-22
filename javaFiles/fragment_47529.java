public class MyFace implements Face() {
    private final int parameter;

    public MyFace(int parameter) {
        this.parameter = parameter;
    }

    @Override
    public void seeThis() {
        System.out.println(parameter);
    }
}