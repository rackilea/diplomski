public class StrategyA implements Strategy {

    public boolean validate(User user){

         return user.getUsername().isEmpty();
    }
}

public class StrategyB implements Strategy {

    public boolean validate(User user){

         return user.getPhone().isEmpty();
    }
}