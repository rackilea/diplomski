private B b;

@Autowire
public void setB(B b) {
    this.b = b;
    b.importantValueFromA = this.importantValue;
}