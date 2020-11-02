package com.overmind.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-02 08:51
 */
@Configuration
@Aspect
@EnableAspectJAutoProxy
@ConditionalOnProperty(prefix = "time.log",name = "enable",havingValue = "true",matchIfMissing = true)
public class TimeLogAutoConfiguration {

    private static final Logger logger = getLogger(TimeLogAutoConfiguration.class);

    @Around("@annotation(com.overmind.logging.TimeLog)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().toLongString().split(" ")[2];
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        logger.info("方法{},执行耗时{} ms",method,end - start);
        return result;
    }
}
