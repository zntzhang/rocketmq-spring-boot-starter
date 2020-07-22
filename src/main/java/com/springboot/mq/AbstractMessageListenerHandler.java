package com.springboot.mq;

import com.springboot.conf.HandlerSingleton;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Auther: zhangtao
 * @Date: 2020/7/14 15:40
 * @Description:
 */
@Component
public abstract class AbstractMessageListenerHandler implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        if (CollectionUtils.isEmpty(msgs)) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        // 会把不同的消息分别放置到不同的队列中
        msgs.forEach(msg ->
//                System.out.println("接收到了消息：" + new String(msg.getBody()))
                doConsumeMessage(msg)
        );
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    public abstract void doConsumeMessage(MessageExt msg);

    @PostConstruct
    public void setHandler() {
        HandlerSingleton.INSTANCE.setInstance(this);
    }
}
