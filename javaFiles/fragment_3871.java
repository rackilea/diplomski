List<Home> homes; // initialize it  with some data
JavaRDD<Individual> homeRDD =  SparkUtil.getSparkContext().parallelize(homes);
   public class Home implements Serializable,Comparable<Home>{ 

        private double price = Math.Random() * 1000; 

         @Override
        public int compareTo(Home o) {
            return Double.compare(this.getPrice(),o.getPrice());
        }
    }