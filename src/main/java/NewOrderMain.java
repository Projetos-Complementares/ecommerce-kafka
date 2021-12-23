import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class NewOrderMain {
    public static void main(String[] args) {
        KafkaProducer<String,String> producer = new KafkaProducer<>(properties());
        //0 = id_pedido, 1 = id_usuario, 122.21 = valor_pedido
        String value = "0,1,122.21";
        ProducerRecord<String,String> record = new ProducerRecord<>("ECOMMERCE_NEW_ORDER",value, value);
        producer.send(record);
    }

    private static Properties properties() {
        Properties properties = new Properties();
        //configura servidor onde roda o kafka
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        //configura tipagem das chaves e valores
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}
