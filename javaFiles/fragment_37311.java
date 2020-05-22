public class Test
{
    public static void main(String[] args)
    {
        String testCase = "enqueue(5, 3), enqueue(51, 60), enqueue(0, 14), enqueue(364, 16), dequeue()";
        // Prepare parameters and invocations
        int[] param1; // assuming it is ready
        int[] param2; // assuming it is ready
        String[] calls; // assuming it is ready

        try
        {
            Class calledClass = Class.forName("OJ.Prob3");
            Method calledMethod1 = calledClass.getDeclaredMethod("enqueue", String.class, int.class);
            Method calledMethod2 = calledClass.getDeclaredMethod("dequeue", null);
            for (int i = 0 ; i < calls.length ; i++)
            {
                if (calls[i].equalsIgnoreCase("enqueue"))
                    calledMethod1.invoke(calledClass.newInstance(), param[i], param2[i]);
                else if (calls[i].equalsIgnoreCase("dequeue"))
                    calledMethod2.invoke(calledClass.newInstance())
            }
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (SecurityException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}