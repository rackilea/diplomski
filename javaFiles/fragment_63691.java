@Bean
public JpaComponent jpa() {
    final JpaComponent jpa = new JpaComponent();
    jpa.setSharedEntityManager(true);
    jpa.setJoinTransaction(false);
    return jpa;
}