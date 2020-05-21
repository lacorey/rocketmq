package org.apache.rocketmq.test.test;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Created by zxin on 2020-05-21.
 */
public class Producer {
    public static void main(String[] args) {
        try{
            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
            producer.setNamesrvAddr("127.0.0.1:9876"); // <x> 哈哈哈哈
            producer.start();
            for(int i = 0; i < 1000; i++){
                Message msg = new Message("TopicTest" /* Topic */,
                        "TagA" /* Tag */,
                        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                SendResult sendResult = producer.send(msg);

                System.out.printf("%s%n", sendResult);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
