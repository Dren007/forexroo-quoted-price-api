package com.github.xuzw.forexroo_quoted_price_api.engine;

import java.util.Collections;

import javax.jms.JMSException;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.apache.activemq.ActiveMQConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.xuzw.activemq_utils.ActiveMq;
import com.github.xuzw.forexroo_quoted_price_api.service.QuotedPriceService;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年6月5日 下午6:24:03
 */
@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
    private static final Logger log = LoggerFactory.getLogger(ServletContextListener.class);

    @SuppressWarnings("unchecked")
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("contextInitialized");
        try {
            String brokerUrl = "failover:tcp://119.23.62.18:61616";
            ActiveMq.init(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, brokerUrl, Collections.EMPTY_LIST);
            ActiveMq.onMessage("Market_Data_Info_Topic", x -> {
                QuotedPriceService.putBid(x.getString("symbol"), x.getString("bid"));
            });
        } catch (JMSException e) {
            log.error("", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contextDestroyed");
    }
}
