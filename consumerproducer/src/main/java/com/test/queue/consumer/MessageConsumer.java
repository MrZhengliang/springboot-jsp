package com.test.queue.consumer;

import com.test.queue.IMsgQueue;
import com.test.queue.MessageManageQueue;
import com.test.queue.pojo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xx on 2017/5/18.
 */
public class MessageConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);


    private IMsgQueue sharedQueue;

    public MessageConsumer(IMsgQueue sharedQueue){
        this.sharedQueue = sharedQueue;
    }
    // 读取消息
    public void readMsg(){
        long start = System.currentTimeMillis();
        logger.info(this.getClass().getSimpleName()+"--> readMsg --> start:{}",start);
        Message msg = sharedQueue.take();
        logger.info(this.getClass().getSimpleName()+"--> readMsg --> msg:{}",msg.toString());
        System.out.println("read msg:"+msg.toString());
        long end = System.currentTimeMillis();
        logger.info(this.getClass().getSimpleName()+"--> buildMsg --> queueSize:{}", sharedQueue.size());
        logger.info(this.getClass().getSimpleName()+"--> readMsg --> end:{}",end);
        logger.info(this.getClass().getSimpleName()+"--> readMsg --> const:{}",(end - start));
    }
}
