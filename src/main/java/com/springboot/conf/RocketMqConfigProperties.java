package com.springboot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: zhangtao
 * @Date: 2020/7/16 16:47
 * @Description:
 */
@ConfigurationProperties("rocketmq")
public class RocketMqConfigProperties {

    // 消费者GROUP
    private String consumerGroup = "pushConsumer";
    // NameServer 地址
    private String namesrvAddr = "127.0.0.1:9876";
    // topic
    private String topic = "default";
    // 生产者的组名
    private String producerGroup = "default";

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getProducerGroup() {
        return producerGroup;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }
}
