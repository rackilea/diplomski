package mapreduce;


import java.io.IOException;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.json.*;

public class CommonErrorsMapper extends Mapper<NullWritable, BytesWritable, TextTriplet, IntWritable> {


         public void map(NullWritable key, BytesWritable value, Context context) throws IOException, InterruptedException{
            String product;
            String version;
            String errorCode;

            String json = new String(value.getBytes());
            try {
                JSONArray jObject = new JSONArray(json);
                for(int i = 0; i < jObject.length(); i++){
                    product = jObject.getJSONObject(i).getString("product");
                    version = jObject.getJSONObject(i).getString("version");
                    errorCode = jObject.getJSONObject(i).getString("errorCode");
                    context.write(new TextTriplet(product, version, errorCode), new IntWritable(1));
                }
            }catch(Exception error){
                error.printStackTrace();
            }
        }
}