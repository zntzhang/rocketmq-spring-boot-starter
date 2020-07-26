package com.springboot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Auther: zhangtao
 * @Date: 2020/7/16 16:47
 * @Description:
 */
// 自动获取配置文件中前缀为rocketmq的属性，把值传入对象参数
@ConfigurationProperties("rocketmq")
public class RocketMqConfigProperties {

    // 消费者GROUP
    private String consumerGroup = "pushConsumer";// 如果配置文件中配置了下面属性，则该默认属性会被覆盖
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
