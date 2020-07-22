package com.springboot.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @Auther: zhangtao
 * @Date: 2020/7/21 21:53
 * @Description:
 */
public class MyMqProducer extends DefaultMQProducer {


    public MyMqProducer(String producerGroup, String topic) {
        super(producerGroup);
        this.topic = topic;
    }

    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public SendResult send(String msg) {
        Message message = new Message();
        message.setBody(msg.getBytes());
        message.setTopic(getTopic());
        int count = 5;
        do {
            try {
                return super.send(message);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                count--;
            }
        } while (count>0);
      return null;
    }
}
