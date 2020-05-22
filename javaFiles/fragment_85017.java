class Row extends HorizontalLayout {

    NumberField totalSamples ;
    Label label ;
    Button start ;

    // Constructor
    public Row ( … ) {
        totalSamples = … ;
        label = … ;
        start = … ;
        this.add( label , totalSamples , start ) ;
    }

}