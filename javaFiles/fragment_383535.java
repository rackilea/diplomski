package de.scrum_master.app;

import java.util.Random;

public class Application {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Application application = new Application();
        for (int i = 0; i < 5; i++) {
            System.out.println(application.doSomething());
            System.out.println(application.getSomething());
            System.out.println(application.getSomethingElse());
        }
    }

    public String doSomething() {
        return "Doing something";
    }

    public @ResponseBody BaseResponse<String> getSomething() {
        BaseResponse<String> response = new BaseResponse<String>();
        if (RANDOM.nextBoolean())
            throw new RuntimeException("cannot get something");
        response.setBody("getting something");
        return response;
    }

    public @ResponseBody BaseResponse<String> getSomethingElse() {
        BaseResponse<String> response = new BaseResponse<String>();
        if (RANDOM.nextBoolean())
            throw new RuntimeException("cannot get something else");
        response.setBody("getting something else");
        return response;
    }
}