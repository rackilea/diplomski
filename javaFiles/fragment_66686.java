public class Foo {
    public enum BarEnum {
        OPTION1,
        OPTION2;

        private BarEnum switchValue ( )
        {
            switch( this )
            {
            case OPTION1:
                 return OPTION2;
            case OPTION2:
                 return OPTION1;
            }

            throw new AssertionError("Should not be here");
        }
    }

    private BarEnum barmember;

    private void switchBarmember {
        barmember = barmember.switchValue( );
    }
}