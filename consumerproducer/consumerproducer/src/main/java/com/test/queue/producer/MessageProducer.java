package com.test.queue.producer;

import com.test.queue.IMsgQueue;
import com.test.queue.MessageManageQueue;
import com.test.queue.pojo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

/**
 * Created by xx on 2017/5/18.
 */
public class MessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    private IMsgQueue sharedQueue;

    public MessageProducer(IMsgQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }
    //生产消息
    public void buildMsg(Message msg){
        long start = System.currentTimeMillis();
        logger.info(this.getClass().getSimpleName()+"--> buildMsg --> start:{}",start);
        logger.info(this.getClass().getSimpleName()+"--> buildMsg --> msg:{}",msg.toString());
        sharedQueue.put(msg);
        long end = System.currentTimeMillis();
        System.out.println("queueSize:,"+sharedQueue.size());
        logger.info(this.getClass().getSimpleName()+"--> buildMsg --> queueSize:{}", sharedQueue.size());
        logger.info(this.getClass().getSimpleName()+"--> buildMsg --> end:{}",end);
        logger.info(this.getClass().getSimpleName()+"--> buildMsg --> const:{}",(end - start));
    }


}
