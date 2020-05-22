public class Notas implements java.io.Serializable {
    transient private SimpleDoubleProperty average;
    //note that this won't serialize so you'd have to create it in readObject()

    ...
    //in the constructor
    this.mediaGeral = mediaGeral;
    average = new SimpleDoubleProperty(mediaGeral);
    ...   
    //make a accessor for the property
    public SimpleDoubleProperty averageProperty(){
        return average;
    }
}