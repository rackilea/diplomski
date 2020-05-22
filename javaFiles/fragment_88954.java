public class User1 {
    private U1Ops u1Ops;
    public User1(U1Ops u1Ops){
        this.u1Ops = u1Ops;
    }
}

// usage of classes
OPS ops = new OPS();
User1 user1 = new User1(ops);
User2 user2 = new User2(ops);