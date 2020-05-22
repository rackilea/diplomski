public class Main
{
    public static void main(String[] args)
    {
        glfwSetKeyCallback(window, new GLFWKeyCallbackProxy());
    }

    class GLFWKeyCallbackProxy extends GLFWKeyCallback
    {
        @Override
        public void invoke(long window, int key, int scancode, int action, int mods)
        {
            // Communicate back to Main
        }
    }
}