package com.paas.template.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

@Service
@Scope("singleton")
@DisconfFile(filename = "template.properties")
@DisconfUpdateService(classes = {TemplateConf.class})
public class TemplateConf implements IDisconfUpdate{
    protected static final Logger LOGGER = LoggerFactory.getLogger(TemplateConf.class);
    
    //TODO  add your buss fileds
    private String host;
    @DisconfFileItem(name = "template.host", associateField = "host")
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    
    public void reload() throws Exception {
    		//TODO your buss
        LOGGER.debug("host: " + host);
    }

}
