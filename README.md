# springboot集成rocketMq的starter工具包
## 准备工作
下载starter工程好后，mvn clean install 一下
## 使用步骤
在你需要集成rocketMq的工程
### 1. pom文件中，引用上面starter的jar包
    ```
        <dependency>
            <groupId>com.springboot</groupId>
            <artifactId>rocketmq-spring-boot-starter</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    ```

### 2. application.yml中添加一下相关配置
    ```
    # 消息队列
    rocketmq:
      #消费者的组
      consumerGroup: pushConsumer
      #生产者的组
      producerGroup: default
      #Nameserver的地址,这里配置你MQ安装的机器上的IP就好，我这里在本机安装的
      namesrvAddr: 127.0.0.1:9876
      #topic
      topic: test
    ```

### 3. 发送端和消费端的处理

- 消费端需要自定义一个consumerHandler继承AbstractMessageListenerHandler，重写doConsumeMessage方法消费消息。

- 生产者注入MyMqProducer，调用send方法即可

### 4. 启动方法添加@EnableRocketMq注解，扫描starter的config