package org.yqj.rocketmq.demo.docs.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Description: 消息同步发送方式
 *
 * @author yaoqijun
 * @date 2019-04-17
 * Email: yaoqijunmail@foxmail.com
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");

        producer.setNamesrvAddr("localhost:9876");

        producer.setVipChannelEnabled(false);

        producer.setUseTLS(false);

        producer.setUnitMode(false);

        producer.start();

        for (int i=0; i<100; i++){
            Message message = new Message("TopicTest", "TagA", ("hello rocketmq " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            SendResult sendResult = producer.send(message);

            System.out.printf("%s%n", sendResult);
        }

        producer.shutdown();
    }
}
