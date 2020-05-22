public static void main(String[] args) throws IOException {
      /* code to find number of route = numRoutes goes here */
      Route[] route = new Route[numRoutes];

      // Initialization:
      for (int i = 0; i < numRoutes; i++) {
           route[i] = new Route();
      }

      /* code to find number of times = count goes here */
      for (int i = 0; i < numRoutes; i++) {
        // without previous initialization, route[i] is null here 
        route[i].departureTimes = new int[count];