package com.hersa.foraclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import org.apache.axis.message.SOAPHeaderElement;

import com.tdcare.www.WS_DataInterchangeServiceLocator;
import com.tdcare.www.WS_DataInterchangeServiceSoap;
import com.tdcare.www.WS_DataInterchangeServiceSoapProxy;
import com.tdcare.www.WS_DataInterchangeServiceSoapStub;

public class Class3 {

    public static void main(String args[]) {

        String iData2 = "<QueryData>\r\n" + 
                "                   <Account>*****</Account>\r\n" + 
                "                   <Password>******</Password>\r\n" + 
                "                   <QSDate>2010/01/01</QSDate>\r\n" + 
                "                   <QEDate>2010/02/01</QEDate>\r\n" + 
                "                   <QMType>1</QMType>\r\n" + 
                "                   <QCase/>\r\n" + 
                "               </QueryData>";
        try {
            WS_DataInterchangeServiceLocator locator = new WS_DataInterchangeServiceLocator();
            WS_DataInterchangeServiceSoapProxy proxy = new WS_DataInterchangeServiceSoapProxy(locator.getWS_DataInterchangeServiceSoapAddress());
            WS_DataInterchangeServiceSoap service = locator.getWS_DataInterchangeServiceSoap();
            WS_DataInterchangeServiceSoapStub stub = new WS_DataInterchangeServiceSoapStub(new URL(locator.getWS_DataInterchangeServiceSoapAddress()), locator);

            String targetNamespace = "http://www.tdcare.com/";
            QName qname = new QName(targetNamespace, "sValidationSoapHeader", new String());
            SOAPHeaderElement sValidationSoapHeader = new SOAPHeaderElement(qname);
            SOAPElement userName = sValidationSoapHeader.addChildElement("Username");
            userName.addTextNode("*****");
            SOAPElement headerPassword = sValidationSoapHeader.addChildElement("Password");
            headerPassword.addTextNode("*****");
            System.err.println(sValidationSoapHeader.toString());
            stub.setHeader(sValidationSoapHeader);
            String resp = stub.dataInterchange("Q0001", iData2);

            System.err.println(resp);


        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SOAPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}