public class Tile {
    LocalDate localDate ;
    static private DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "EEE dd MMM" , Locale.US ) ;

    public Tile( LocalDate localDateArg ) {
        this.localDate = localDateArg ;
    }

    public String getDisplayName() {
        String output = this.localDate.format( Tile.formatter ) ;
        return output ;
    }

    @Override
    public String toString() {
        String output = Tile.class.getSimpleName() + "{ localDate:" + this.localDate.toString() + " }" ;
    }

}