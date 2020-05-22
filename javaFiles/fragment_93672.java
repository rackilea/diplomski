public class EnumTest
{
    public static void main(final String[] args)
    {
        final Option o = Option.safeValueOf(args[0]);
        switch(o)
        {
            case CHOICE_A: // fall through
            case CHOICE_B: // fall through
            case CHOICE_C: // fall through
                System.out.format("You selected %s", o );
                break;
            case CHOICE_D:
                System.out.format("You selected %s", o);
                break;
            default:
                System.out.format("Default Choice is %s", o );
        }
    }

    public enum Option
    {
        UNRECOGNIZED_CHOICE, CHOICE_A, CHOICE_B, CHOICE_C;

        // this hides the Exception handling code
        // so you don't litter your code with try/catch blocks
        Option safeValueOf(final String s)
        {
            try
            {
                return Option.valueOf(s);
            }
            catch (final IllegalArgumentException e)
            {
                return UNRECOGNIZED_CHOICE;
            }
        }
    }
}