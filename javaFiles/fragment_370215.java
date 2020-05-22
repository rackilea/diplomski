/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oidc.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    /**
     * This variable is used in order to keep track of the original URL the user
     * passed before he logged out
     */
    private String originalURL;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication != null && authentication.getDetails() != null) {
            try {
                request.getSession().invalidate();
                System.out.println("User Successfully Logout");
                //you can add more codes here when the user successfully logs out,
                //such as updating the database for last active.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Set the Server Status
        response.setStatus(HttpServletResponse.SC_OK);

        //----------- Choose where to redirect------------------
        System.out.println("Hello from [ CustomLogoutSuccessHandler ] \n");
        System.out.println("Original URL is : " + originalURL);

        //Check if any parameters have been passed
        String redirectURL = null;
        if (originalURL != null) {

            try {
                //Get all the parameters from the url
                MultiValueMap<String, String> parameters
                        = UriComponentsBuilder.fromUriString(originalURL).build().getQueryParams();

                //--Get the parameter value 
                List<String> value = parameters.get("redirect");
                if (value.size() != 0) { //if it exists
                    redirectURL = value.get(0);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // Decide where to redirect
        System.out.println(" Redirect : " + redirectURL);
        if (redirectURL == null) {
            response.sendRedirect("/oidc/");
        } else {
            response.sendRedirect(redirectURL);
        }
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

}