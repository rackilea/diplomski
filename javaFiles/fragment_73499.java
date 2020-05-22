List<Order> orderList = new ArrayList<Order>();
    orderList.add(cb.asc(cb.selectCase().when(cb.equal(root.get("tdnEco"), ConstantesCliente.TIPO_DOMINIO_APROBADO), 1).when(cb.equal(root.get("tdnEco"), ConstantesCliente.TIPO_DOMINIO_ABIERTO), 2)
            .when(cb.equal(root.get("tdnEco"), ConstantesCliente.TIPO_DOMINIO_PTE_TRAMITE), 3).when(cb.equal(root.get("tdnEco"), ConstantesCliente.TIPO_DOMINIO_RECHAZADO), 4)
            .when(cb.equal(root.get("tdnEco"), ConstantesCliente.TIPO_DOMINIO_RECHAZADO), 5).otherwise(6)));

    orderList.add(cb.asc(root.get("nomCol")));

    query.orderBy(orderList);