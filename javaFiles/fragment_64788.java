package com.tarkshala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillDAO {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public BillDAO(final DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void create(BillDO billDO) {
        dynamoDBMapper.save(billDO);
    }
}