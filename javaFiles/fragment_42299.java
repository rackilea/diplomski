public static List<String> selectNome(){
    Query selectAll = em.createQuery("SELECT p.nome FROM Persone p");
    @SuppressWarnings("unchecked")
    List<String> qnome = selectAll.getResultList();
    return qnome;
}