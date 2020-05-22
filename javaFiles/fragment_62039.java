public class TheMapper extends Mapper<LongWritable, Text, Text, ArrayPrimitiveWritable>{        

    protected void map(LongWritable offset, Text value, Context context) 
    throws IOException, InterruptedException {

        StringTokenizer tok = new StringTokenizer( value.toString(), "," );

        Text col1 = new Text( tok.nextToken() );
        context.write( col1, toArray(1, 0) );

        Text col2 = new Text( tok.nextToken() );        
        context.write( col2, toArray(0, 1) );
    }

    private ArrayPrimitiveWritable toArray(int v1, int v2){     
        return new ArrayPrimitiveWritable( new int[]{i1, i2} );
    }   
}

public class TheReducer extends Reducer<Text, ArrayPrimitiveWritable, Text, Text> {

  public void reduce(Text key, Iterable<ArrayPrimitiveWritable> values, Context context) 
  throws IOException, InterruptedException {

      Iterator<ArrayPrimitiveWritable> i = values.iterator();
      int count = 0;
      while ( i.hasNext() ){
          int[] counts = (int[])i.next().get();
          count += counts[0];
          count -= counts[1];
      }

      context.write( key, new Text("" + count) );
  }
}