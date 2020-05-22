import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.MockConsumer;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.TopicPartition;

...
        String topic = "MyTopic";
        Collection<TopicPartition> partitions = new ArrayList<TopicPartition>();
        Collection<String> topicsCollection = new ArrayList<String>();
        partitions.add(new TopicPartition(topic, 1));
        Map<TopicPartition, Long> partitionsBeginningMap = new HashMap<TopicPartition, Long>();
        Map<TopicPartition, Long> partitionsEndMap = new HashMap<TopicPartition, Long>();

        long records = 10;
        for (TopicPartition partition : partitions) {
            partitionsBeginningMap.put(partition, 0l);
            partitionsEndMap.put(partition, records);
            topicsCollection.add(partition.topic());
        }

        MockConsumer<String, MyObject> second = new MockConsumer<String, MyObject>(
                OffsetResetStrategy.EARLIEST);
        second.subscribe(topicsCollection);
        second.rebalance(partitions);       
        second.updateBeginningOffsets(partitionsBeginningMap);
        second.updateEndOffsets(partitionsEndMap);
        for (long i = 0; i < 10; i++) {
            MyObject value = Generator.generate();
            ConsumerRecord<String, MyObject> record = new ConsumerRecord<String, MyObject>(
                    topic, 1, i, null,value);
            second.addRecord(record);
        }
    ...