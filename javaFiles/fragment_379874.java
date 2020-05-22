// red-my-api.jar
public class RedMyAPI implements MyAPI {
    public String doSomething() {
        return "red";
    }
}

// green-my-api.jar
public class GreenMyAPI implements MyAPI {
    public String doSomething() {
        return "green";
    }
}

// black-my-api.jar
public class BlackMyAPI implements MyAPI {
    public String doSomething() {
        return "black";
    }
}