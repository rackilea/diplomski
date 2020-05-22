/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oidc.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.saml.SAMLLogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 *
 * @author GOXR3PLUS
 */
public class CustomSAMLLogoutFilter extends SAMLLogoutFilter {

    private LogoutSuccessHandler logoutSuccessHandler;

    public CustomSAMLLogoutFilter(String successUrl, LogoutHandler[] localHandler, LogoutHandler[] globalHandlers) {
        super(successUrl, localHandler, globalHandlers);
    }

    public CustomSAMLLogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler[] localHandler, LogoutHandler[] globalHandlers) {
        super(logoutSuccessHandler, localHandler, globalHandlers);
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Override
    public void processLogout(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.processLogout(request, response, chain);

        //   System.out.println("Hello from [ CustomSAMLLogoutFilter ] ");
        //Lets print some information here
        System.out.println("FULL HttpServletRequest URL is : " + getFullURL(request));

        //Downcast and pass it as parameter
        ((CustomLogoutSuccessHandler) logoutSuccessHandler).setOriginalURL(getFullURL(request));
        //   System.out.println("Chao chao from [ CustomSAMLLogoutFilter ] \n");
    }

    /**
     * Returns the full URL of the HTTPServletRequest
     */
    public static String getFullURL(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }

}