@Bean
List<Binding> bindings() {

    return Arrays.AsList(BindingBuilder.bind(queue()).to(exchange()).with(topic1), 
                        BindingBuilder.bind(queue()).to(exchange()).with(topic2));
}