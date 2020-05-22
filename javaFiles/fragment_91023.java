if(!name && name.trim().equals("")){
    Cliente checkedCliente = clientes.stream()
                .filter(x -> name.equals(x.getName()))    // check name is there?
                .findAny()
                .orElse(null);

    if(checkedCliente == null){
        Cliente cliente = new Cliente(name);
        clientes.add(cliente);
        System.out.println("Cliente "+cliente.getName+" Adicionado")
    }
    else {
        System.out.println("Cliente " + cliente.getName() + "is already in the collection");

        // checkedCliente can be used for updates etc in here.
    }
}