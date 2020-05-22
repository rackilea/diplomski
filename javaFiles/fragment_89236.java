rule "rule 1"
when
    ball: Ball( size == 14, brand ==  "NIVIA",
                colour == new HashSet( Arrays.asList("Red", "Black", "Blue") ) )
then
    ball.setPrice(...);
end