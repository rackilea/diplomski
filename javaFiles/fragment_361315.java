package com.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.sample.component.Sample;

@Component
public class SampleMain {

    @Autowired
    Sample testSample;

    static ApplicationContext appCtx = new ClassPathXmlApplicationContext("META-INF/webmvc-application.xml");

    public static void main(String[] args){

        SampleMain sampleMain = appCtx.getBean(SampleMain.class);
        sampleMain.invokeSample();
    }

    private void invokeSample(){
        testSample.invokeSample();
    }

}