package org.apache.rocketmq.test.test;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.rocketmq.common.namesrv.NamesrvConfig;
import org.apache.rocketmq.namesrv.NamesrvController;
import org.apache.rocketmq.remoting.netty.NettyServerConfig;

/**
 * Created by zxin on 2020-05-21.
 */
public class NamesrvService {
    public static void main(String[] args) {
        try{
            final NamesrvConfig namesrvConfig = new NamesrvConfig();
            final NettyServerConfig nettyServerConfig = new NettyServerConfig();
            nettyServerConfig.setListenPort(9876);
            NamesrvController namesrvController = new NamesrvController(namesrvConfig,nettyServerConfig);
            namesrvController.initialize();
            namesrvController.start();
            Thread.sleep(DateUtils.MILLIS_PER_DAY);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
