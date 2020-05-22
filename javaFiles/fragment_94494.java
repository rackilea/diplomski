public class Main
{
    public static void main(String[] args)
    {
        glfwSetKeyCallback( window, Main::invoke );
    }

    void invoke(long window, int key, int scancode, int action, int mods)
    {
        // Communicate back to Main
    }
}