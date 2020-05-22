package com.hotjoe.aws.lambda.hello.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


@SuppressWarnings("unused")
public class HelloWorldLambdaHandler implements RequestHandler<HelloWorldLambdaHandler.InputObject, String> {

    public String handleRequest(InputObject inputObject, Context context) {

        System.out.println( "got \"" + inputObject + "\" from call" );

        return "{\"result\": \"hello lambda java\"}";
    }

    public static class InputObject {
        private String key1;
        private String key2;
        private String key3;

        public String getKey1() {
            return key1;
        }

        public String getKey2() {
            return key2;
        }

        public String getKey3() {
            return key3;
        }

        public void setKey1(String key1) {
            this.key1 = key1;
        }

        public void setKey2(String key2) {
            this.key2 = key2;
        }

        public void setKey3(String key3) {
            this.key3 = key3;
        }

        @Override
        public String toString() {
            return "InputObject{" +
                    "key1='" + key1 + '\'' +
                    ", key2='" + key2 + '\'' +
                    ", key3='" + key3 + '\'' +
                    '}';
        }
    }
}