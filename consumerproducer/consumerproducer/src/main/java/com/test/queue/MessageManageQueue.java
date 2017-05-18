package com.test.queue;

import com.test.queue.pojo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by xx on 2017/5/18.
 */
public class MessageManageQueue implements IMsgQueue {

    private static final Logger logger = LoggerFactory.getLogger(MessageManageQueue.class);


    public final BlockingQueue<Message> messageQueue;

    public MessageManageQueue(){
        messageQueue = new LinkedTransferQueue<Message>();
    }

//    public static MessageManageQueue getInstance(){
//        MessageManageQueue messageQueue = new MessageManageQueue();
//        return messageQueue;
//    }

    public void put(Message msg) {
        try {
            messageQueue.put(msg);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public Message take() {
        try {
            System.out.println("size:"+messageQueue.size());
           return messageQueue.take();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return null;
    }

    @Override
    public int size() {
        return messageQueue.size();
    }
}
