package com.developerbhuwan.velocityemailtemplate;

import java.io.StringWriter;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 *
 * @author developerbhuwan
 */
public class VelocityEmailGenerator {

    public static void main(String[] args) {

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("user", "Ram");
        velocityContext.put("message", "You registration accepted");
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        StringWriter writer = new StringWriter();
        velocityEngine.mergeTemplate("emailTemplate.vsl", "utf-8", velocityContext, writer);
        System.out.println("Email : " + writer.toString());

        /*
         String mailMessage = writer.toString();
         mailSender.sendMail(mailMessage, .........)
         */

    }
}