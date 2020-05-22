public class Server {

    public static void main(String[] args) {
        Spark.get(new VelocityRoute("/hello") {
            @Override
            public Object handle(final Request request, final Response response) {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("hello", "Velocity World");
                model.put("person", new Person("Foobar"));

                // The wm files are located under the resources directory
                return modelAndView(model, "hello.wm");
            }
        });
    }

    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}