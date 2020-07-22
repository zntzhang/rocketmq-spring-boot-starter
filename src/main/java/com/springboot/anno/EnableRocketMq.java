package com.springboot.anno;

import com.springboot.conf.RocketMqConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Auther: zhangtao
 * @Date: 2020/7/16 17:01
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RocketMqConfig.class)
public @interface EnableRocketMq {
}
