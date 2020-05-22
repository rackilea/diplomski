package com.parquet.avro;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetReader;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetFileWriter;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.hadoop.util.HadoopInputFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class ParquetAvroHandler
{
    private static final Schema SCHEMA; 
    private static final String SCHEMA_PATH = "path/to/your/schema.avsc";
    private static final Path OUTPUT_PATH = new Path("result.parquet");
    private static final Logger LOGGER = LoggerFactory.getLogger(ParquetAvroHandler.class);

    static
    {
        try (InputStream inStream = ParquetAvroHandler.class.getResourceAsStream(SCHEMA_PATH))
        {
            SCHEMA = new Schema.Parser().parse(IOUtils.toString(inStream, "UTF-8"));
        }
        catch (Exception e)
        {
            LOGGER.error("Can't read SCHEMA file from {}", SCHEMA_PATH);
            LOGGER.error(e.getLocalizedMessage());
            throw new RuntimeException("Can't read SCHEMA file from " + SCHEMA_PATH, e);
        }
    }

    /**
     * Reads an existing Apache Avro-based Parquet file from the
     * specified location and prints it into the system console
     * 
     * @param filePath path to the input file
     * @throws IOException
     **/
    public void read(Path filePath) throws IOException
    {
        Configuration configuration = new Configuration();
        HadoopInputFile inputFile = HadoopInputFile.fromPath(filePath, configuration);

        try (ParquetReader<GenericData.Record> reader = AvroParquetReader
                .<GenericData.Record>builder(inputFile)
                .withConf(configuration)
                .build())
        {
            GenericData.Record record;
            while ((record = reader.read()) != null)
            {
                System.out.println(record);
            }
        }
    }

    /**
     * Creates a new Apache Avro-based Parquet file or overwrites the existing one
     *  
     * @param records set of records to write to the file
     * @param filePath path to the output file
     * @throws IOException
     **/
    public void write(List<GenericData.Record> records, Path filePath) throws IOException
    {
        try (ParquetWriter<GenericData.Record> writer = AvroParquetWriter
                .<GenericData.Record>builder(filePath)
                .withSchema(SCHEMA)
                .withConf(new Configuration())
                .withCompressionCodec(CompressionCodecName.SNAPPY)
                .withWriteMode(ParquetFileWriter.Mode.OVERWRITE)
                .build())
        {

            for (GenericData.Record record : records)
            {
                writer.write(record);
            }
        }
    }

    public static void main(String[] args) //throws IOException
    {
        try
        {
            GenericData.Record record = new GenericData.Record(SCHEMA);

            record.put("Name", "John");
            record.put("Id", 1);
            record.put("PhoneNumber", "555-555-5551");
            record.put("ZipCode", 88888);
            record.put("isAlive", true);
            records.add(record);

            record = new GenericData.Record(SCHEMA);
            record.put("Name", "Jane");
            record.put("Id", 2);
            record.put("PhoneNumber", "555-555-5552");
            record.put("ZipCode", 99999);
            record.put("isAlive", false);
            records.add(record);

            ParquetAvroHandler handler = new ParquetAvroHandler();
            handler.write(records, OUTPUT_PATH);
            handler.read(OUTPUT_PATH);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }
}