package com.test.queue;

import com.test.queue.pojo.Message;

/**
 * Created by xx on 2017/5/18.
 */
public interface IMsgQueue {

    public void put(Message msg);

    public Message take();

    public int size();
}
