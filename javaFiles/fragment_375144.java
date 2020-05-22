public HashMap<String, String> getOnlyDistritoTarificacion(String numero) {

    List<String> distritos = new ArrayList();

    HashMap<String, String> distrito = new HashMap();

    List<Map<String, Object>> filas_distritos = jdbcTemplate.queryForList(CONSULTA_SOLO_DISTRITOS, new Object[]{numero, numero});

    if ((filas_distritos != null) && (!filas_distritos.isEmpty()) || (filas_distritos.size() != 0)) {

        Map<String, Object> row = filas_distritos.get(0);

        distritos.add((String) row.get("DISTRITO"));
        distritos.put("distrito", (String) row.get("DISTRITO"));

    }

    distrito.put("distrito", 
                 distritos.stream()
                 .collect(Collectors.joining(","));

    return distrito;
}