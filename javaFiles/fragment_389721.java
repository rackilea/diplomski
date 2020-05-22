public void catchFly(int value) {
    super.catchFly();
    account.credit(value);
    super.yellow();
    super.jump();
    super.green();
}