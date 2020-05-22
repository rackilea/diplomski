public class Foobar extends AbstractFoo {

    @Override
    public Object clone() {
        try {
            Foobar c = (Foobar) super.superDotClone();
            /* some operations */
            return c;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

}