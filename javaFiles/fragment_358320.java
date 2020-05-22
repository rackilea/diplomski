package com.heap.monitor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.management.*;
import javax.management.remote.*;

public class HeapMonitor extends Thread {

private JMXServiceURL jmxService = null;
private JMXConnector jmxConnector = null;
protected MBeanServerConnection beanServerConn = null;
private long frequency = 2 * 60 * 1000L; // 2 mins only collects Heap metrics
private String jmxUrl = "service:jmx:rmi:///jndi/rmi://192.168.8.252:12222/jmxrmi";
private String userName = "none";
private String passWord = "none";

public static void main(String[] args) throws InterruptedException {
    HeapMonitor heapMonitor = new HeapMonitor();
    heapMonitor.join();
}

public HeapMonitor() {
    this.start();
}

public void run() {
    boolean flag = true;
    while(flag) {
        try {
            beanServerConn = connectToJVM(jmxUrl, userName, passWord);
            if(beanServerConn!=null) {
                MemoryMXBean mxbean = (MemoryMXBean) ManagementFactory.newPlatformMXBeanProxy(beanServerConn, ManagementFactory.MEMORY_MXBEAN_NAME, MemoryMXBean.class);
                try
                {
                    MemoryUsage heapUsage = mxbean.getHeapMemoryUsage();
                    long used = heapUsage.getUsed();
                    long max = heapUsage.getMax();
                    long commited = heapUsage.getCommitted();
                    long init = heapUsage.getInit();
                    StringBuffer buffer = new StringBuffer();
                    Date date = new Date();
                    buffer.append(date).append(" - ");
                    buffer.append(init).append("   ").append(commited).append("   ").append(max).append("   ").append(used);
                    //System.out.println(buffer.toString());
                    appendStrToFile("heap.txt" , buffer.toString());
                }
                catch(Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(frequency);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

protected MBeanServerConnection connectToJVM(String jvmURL, String user, String pass)
{
    beanServerConn = null ;  
    try
    {
        jmxService = new JMXServiceURL(jvmURL);
        Map environment = new HashMap();
        int jmxconnect_timeout = 30000;
        environment.put("jmx.remote.x.request.waiting.timeout", Long.toString(jmxconnect_timeout));


        if(user.equalsIgnoreCase("none")|| (pass.equalsIgnoreCase("none"))){
            try{
                jmxConnector = JMXConnectorFactory.connect(jmxService,environment);
                beanServerConn = jmxConnector.getMBeanServerConnection();
            }
            catch(IOException ioe){
            }
        }
        else
        {
            String [] credentials={user,pass};
            environment.put(JMXConnector.CREDENTIALS, credentials);
            try{
                jmxConnector = JMXConnectorFactory.connect(jmxService,environment);
                beanServerConn = jmxConnector.getMBeanServerConnection();

            }
            catch(IOException ioe){
            }
        }

        beanServerConn = jmxConnector.getMBeanServerConnection();

        if(beanServerConn == null)
        {
            System.out.println("Connection to JVM is not established for jvmURL : " + jvmURL);
            closeJVMConn();
        }
    }
    catch(Exception ex)
    {
        System.out.println("Connection to JVM is not established for jvmURL : " + jvmURL);
        closeJVMConn();
    }
    return beanServerConn;
}

public void closeJVMConn(){
    try{
        beanServerConn = null;
        if(jmxConnector != null)
            jmxConnector.close();
    }
    catch(Exception ex){
        return;
    }
}

 public void appendStrToFile(String fileName, String str) { 
    try { 
        // Open given file in append mode. 
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true)); 
        out.write(str); 
        out.newLine();
        out.close(); 
    } 
    catch (IOException e) { 
        System.out.println("exception occoured" + e); 
    } 
 } 
}