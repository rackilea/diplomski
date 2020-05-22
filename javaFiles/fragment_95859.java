public class Coord {

    private static final Complex[] z = fixedRandomPoints(5);

    private Coord() {}

    //this is the method you call from both canvases
    public static Complex[] getInstance() {
       return z;
    }

    private static Complex[] fixedRandomPoints(int n) {         
        final Complex[] results = new Complex[n];
        for(int i = 0; i < n.length; i++){         
            results[i] = new Complex(200 * Math.random(), 200 * Math.random());            
        }         
        return results;
    }

}