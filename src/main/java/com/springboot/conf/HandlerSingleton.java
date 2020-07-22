package com.springboot.conf;

import com.springboot.mq.AbstractMessageListenerHandler;

/**
 * @Auther: zhangtao
 * @Date: 2020/7/17 11:28
 * @Description:
 */
public enum HandlerSingleton {
    INSTANCE;
    private AbstractMessageListenerHandler handler;

    public void setInstance(AbstractMessageListenerHandler handler) {
        this.handler = handler;
    }

    public AbstractMessageListenerHandler getInstance() {
        return handler;
    }
}
