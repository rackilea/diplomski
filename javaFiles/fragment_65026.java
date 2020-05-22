public interface Timmed {}
public interface Intent {}
public interface TimmedIntent extends Timmed, Intent {}
public class TimmedIntentClass implements TimmedIntent {}
public class TimmedAndIntent1 implements Timmed, Intent {}
public class TimmedAndIntent2 implements Timmed, Intent {}