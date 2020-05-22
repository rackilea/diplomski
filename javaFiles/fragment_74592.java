public interface MyInterface {

    void exec();

    default void exec(int param) {
        exec();
    }
}