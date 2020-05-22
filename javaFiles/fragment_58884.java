package mypackage.io;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class KafkaCustomPartitioner {

public static void main(String[] args) throws InterruptedException, ExecutionException {

    long events = Long.parseLong(args[0]);
    int  blocks = Integer.parseInt(args[1]);
    Random rnd = new Random();

    Properties props = new Properties();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
    props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "mypackage.io.CustomPartitioner");
    props.put(ProducerConfig.ACKS_CONFIG, "1");

    KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

    for(int nBlocks=0; nBlocks<blocks; nBlocks++) {

        for(long nEvents=0; nEvents<events; nEvents++) {

            long runTime = new Date().getTime();
            String msg   = runTime + ": " + (50+nBlocks) + ": " + nEvents + ": " + rnd;
            producer.send(new ProducerRecord<String, String>("CustPartTopic", String.valueOf(nBlocks), msg)).get();
        }
    }
    producer.close();
    }
 }