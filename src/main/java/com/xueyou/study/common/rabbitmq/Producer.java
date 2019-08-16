package com.xueyou.study.common.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * 创建 by xueyo on 2019/8/16
 * 消息生产者
 */
@Component
public class Producer {

    private final AmqpTemplate template;

    public Producer(AmqpTemplate template) {
        this.template = template;
    }

    /**
     * 发送消息 - 根据路由
     * @param routingKey    路由键
     * @param msg   消息
     */
    public void sendDirectMsg(String routingKey, Object msg) {
        template.convertAndSend(routingKey, msg);
    }


    /**
     * 发送消息 - 根据路由和指定交换器
     * @param exchange  交换器名称
     * @param routingKey    路由键
     * @param msg   消息
     */
    public void sendExchangeMsg(String exchange, String routingKey, Object msg) {
        template.convertAndSend(exchange, routingKey, msg);
    }


}