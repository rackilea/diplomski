package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaCreateUser implements RequestHandler<RegistrationRequest, String> {


    public String handleRequest(RegistrationRequest input, Context context) {

        context.getLogger().log("Input: " + input.getFirstName());
        Boolean userStatus = false;

        try {

        CognitoSaveUser newUser = new CognitoSaveUser();
        userStatus = newUser.saveNewUserInDB(input, context);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return "Hello from Lambda-"+userStatus.toString();
    }

}