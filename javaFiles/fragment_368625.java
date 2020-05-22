public class Example {
    public static void main(String[] args) throws Exception {
        Whatever<Self> s = new Whatever<>();
    }
}

class Self extends ArrayList<Self> {
}

class Whatever<E extends Collection<E>> {
}