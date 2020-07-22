package com.springboot.conf;

import com.springboot.mq.MyMqProducer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: zhangtao
 * @Date: 2020/7/16 16:24
 * @Description:
 */
@Configuration
@EnableConfigurationProperties(RocketMqConfigProperties.class)
public class RocketMqConfig {

    @Autowired
    private RocketMqConfigProperties rocketMqConfigProperties;

    @Bean
    DefaultMQPushConsumer getConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(rocketMqConfigProperties.getConsumerGroup());
        consumer.setNamesrvAddr(rocketMqConfigProperties.getNamesrvAddr());
        try {
            // 订阅PushTopic下Tag为push的消息,都订阅消息
            consumer.subscribe(rocketMqConfigProperties.getTopic(), "*");
            // 程序第一次启动从消息队列头获取数据
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            //可以修改每次消费消息的数量，默认设置是每次消费一条
            consumer.setConsumeMessageBatchMaxSize(1);
            //在此监听中消费信息
            consumer.registerMessageListener(HandlerSingleton.INSTANCE.getInstance());

            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consumer;
    }

    @Bean
    MyMqProducer getProducer() {
        //生产者的组名
        MyMqProducer producer = new MyMqProducer(rocketMqConfigProperties.getProducerGroup(), rocketMqConfigProperties.getTopic());
        //指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr(rocketMqConfigProperties.getNamesrvAddr());
        producer.setVipChannelEnabled(false);
        try {
            producer.start();
            System.out.println("-------->:producer启动了");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return producer;
    }
}
