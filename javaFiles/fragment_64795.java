{
      "layers" : [
          {"label":"layer", "input":300,output":8000},
          {"label":"layer1", "input":300,"output":8000},
          {"label":"layer2", "input":300,"output":8000}
      ]
    }

    public class Layer {
       int input;
       int output;
       String label;
   }

    public class Network {
        ArrayList<Layer> layers;
    }