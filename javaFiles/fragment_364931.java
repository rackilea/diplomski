package com.ansari.examples.javahttpapiclient;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class JavaHTTPAPIClient {
public void getQuestionsUsingUnirest() throws Exception {
    HttpResponse<JsonNode> response = Unirest.get("https://sandbox.tangocard.com/raas/v1.1/orders/116-101338692-28").
            header("accept",  "application/json").
            header("Authorization", "Basic VGFuZ29UZXN0OjV4SXRyM2RNRGxFV0FhOVM0czd2WWg3a1EwMWQ1U0ZlUFBVb1paaUsvdk1mYm8zQTVCdkpMQW1ENHRJPQ==").
            asJson();
    System.out.println(response.getBody().getObject().toString(2));
}

public static void main(String args[]) throws Exception {
    JavaHTTPAPIClient client = new JavaHTTPAPIClient();
    client.getQuestionsUsingUnirest();
}
}