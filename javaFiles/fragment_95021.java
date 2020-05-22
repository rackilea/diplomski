@Bean
public GUI gui() {
    return new GUI() {
        @Override
        protected JButton getButton(String name) {
            // note, here you're referencimg your Bean jButton of scope "prototype"
            return jButton(name);
        }
    }
}