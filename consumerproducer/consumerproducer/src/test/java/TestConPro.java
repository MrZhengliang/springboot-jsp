import com.test.queue.IMsgQueue;
import com.test.queue.MessageManageQueue;
import com.test.queue.consumer.MessageConsumer;
import com.test.queue.pojo.Message;
import com.test.queue.producer.MessageProducer;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xx on 2017/5/18.
 */
public class TestConPro {

    MessageProducer messageProducer;

    MessageConsumer messageConsumer;

    //Creating shared object
    IMsgQueue sharedQueue = new MessageManageQueue();
    @Test
    public void testConsProd(){

        messageProducer = new MessageProducer(sharedQueue);
        for(int i=0;i<100;i++){
            Message msg = new Message();
            msg.setTitle("消息"+i);
            msg.setContent("content"+i);
            messageProducer.buildMsg(msg);
        }

        messageConsumer = new MessageConsumer(sharedQueue);
        for(int i=0;i<100;i++){
            messageConsumer.readMsg();
        }

    }
}
