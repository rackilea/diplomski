package com.mycompany.stackoverflow;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.MutableDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        String schema = "{\"namespace\": \"org.myorganization.mynamespace\"," //Not used in Parquet, can put anything
                + "\"type\": \"record\"," //Must be set as record
                + "\"name\": \"myrecordname\"," //Not used in Parquet, can put anything
                + "\"fields\": ["
                + " {\"name\": \"myInteger\", \"type\": \"int\"}," //Required field
                + " {\"name\": \"myString\",  \"type\": [\"string\", \"null\"]},"
                + " {\"name\": \"myDecimal\", \"type\": [{\"type\": \"fixed\", \"size\":16, \"logicalType\": \"decimal\", \"name\": \"mydecimaltype1\", \"precision\": 32, \"scale\": 4}, \"null\"]},"
                + " {\"name\": \"myDate\", \"type\": [{\"type\": \"int\", \"logicalType\" : \"date\"}, \"null\"]}"
                + " ]}";

        Schema.Parser parser = new Schema.Parser().setValidate(true);
        Schema avroSchema = parser.parse(schema);

        GenericData.Record record = new GenericData.Record(avroSchema);
        record.put("myInteger", 1);
        record.put("myString", "string value 1");

        BigDecimal myDecimalValue = new BigDecimal("99.9999");

        //First we need to make sure the huge decimal matches our schema scale:
        myDecimalValue = myDecimalValue.setScale(4, RoundingMode.HALF_UP);

        //Next we get the decimal value as one BigInteger (like there was no decimal point)
        BigInteger myUnscaledDecimalValue = myDecimalValue.unscaledValue();

        //Finally we serialize the integer
        byte[] decimalBytes = myUnscaledDecimalValue.toByteArray();

        //We need to create an Avro 'Fixed' type and pass the decimal schema once more here:
        GenericData.Fixed fixed = new GenericData.Fixed(new Schema.Parser().parse("{\"type\": \"fixed\", \"size\":16, \"precision\": 32, \"scale\": 4, \"name\":\"mydecimaltype1\"}"));

        byte[] myDecimalBuffer = new byte[16];
        if (myDecimalBuffer.length >= decimalBytes.length) {            
            //Because we set our fixed byte array size as 16 bytes, we need to
            //pad-left our original value's bytes with zeros
            int myDecimalBufferIndex = myDecimalBuffer.length - 1;
            for(int i = decimalBytes.length - 1; i >= 0; i--){
                myDecimalBuffer[myDecimalBufferIndex] = decimalBytes[i];
                myDecimalBufferIndex--;
            }

            //Save result
            fixed.bytes(myDecimalBuffer);
        } else {
            throw new IllegalArgumentException(String.format("Decimal size: %d was greater than the allowed max: %d", decimalBytes.length, myDecimalBuffer.length));
        }

        //We can finally write our decimal to our record
        record.put("myDecimal", fixed);

        //Get epoch value
        MutableDateTime epoch = new MutableDateTime(0l, DateTimeZone.UTC);

        DateTime currentDate = new DateTime(); //Can take Java Date in constructor
        Days days = Days.daysBetween(epoch, currentDate);

        //We can write number of days since epoch into the record
        record.put("myDate", days.getDays());

        try {
           Configuration conf = new Configuration();
           conf.set("fs.s3a.access.key", "ACCESSKEY");
           conf.set("fs.s3a.secret.key", "SECRETKEY");
           //Below are some other helpful settings
           //conf.set("fs.s3a.endpoint", "s3.amazonaws.com");
           //conf.set("fs.s3a.aws.credentials.provider", "org.apache.hadoop.fs.s3a.SimpleAWSCredentialsProvider");
           //conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName()); // Not needed unless you reference the hadoop-hdfs library.
           //conf.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName()); // Uncomment if you get "No FileSystem for scheme: file" errors.

           Path path = new Path("s3a://your-bucket-name/examplefolder/data.parquet");

           //Use path below to save to local file system instead
           //Path path = new Path("data.parquet");

           try (ParquetWriter<GenericData.Record> writer = AvroParquetWriter.<GenericData.Record>builder(path)
                   .withSchema(avroSchema)
                   .withCompressionCodec(CompressionCodecName.GZIP)
                   .withConf(conf)
                   .withPageSize(4 * 1024 * 1024) //For compression
                   .withRowGroupSize(16 * 1024 * 1024) //For write buffering (Page size)
                   .build()) {

               //We only have one record to write in our example
               writer.write(record);
           }
        } catch (Exception ex) { 
            ex.printStackTrace(System.out);
        }
    }
}