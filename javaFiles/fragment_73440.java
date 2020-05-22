package com.logger.impl;

@Component
public class RequestLoggerImpl implements RequestLogger {

    @Autowired
    private RequestLogDao requestLogDao;

}