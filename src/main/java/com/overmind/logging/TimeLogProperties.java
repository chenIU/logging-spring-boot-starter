package com.overmind.logging;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-02 08:50
 */
@ConfigurationProperties(prefix = "time.log")
public class TimeLogProperties {

    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
