public static void main(String[] args) {
        Pilita pila = new Pilita(3);
        pila.push("1");
        pila.push("2");
        pila.push("3");
        while (!pila.pilaVacia()) {
            System.out.println("Pil pop " + pila.pop());
        }
    }