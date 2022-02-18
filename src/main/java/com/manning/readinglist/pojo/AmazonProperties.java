package com.manning.readinglist.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon") // 注入带“amazon”前缀的属性
public class AmazonProperties {

    private String associateId;

    /**
     * knowledge point: 根据setter来实现的赋值
     */
    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getAssociateId() {
        return associateId;
    }

}
