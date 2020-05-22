@PostMapping("/itensdevendas")
    public ProdutoPedido salvarProdutoPedido(@RequestBody ProdutoPedidoDTO produtoPedidoDTO) {

        ProdutoPedido prodPedido = new ProdutoPedido();
        // add values

        System.out.println("Primeiro: " + produtoPedidoDTO.getProduto());

        // add Produto obj to ProdutoPedido
        Produto produto = new Produto();
        //produto.setId(produtoPedidoDTO.getProduto());
        produto = produtoRepository.findById(produtoPedidoDTO.getProduto()).get();
        prodPedido.setProduto(produto);

        System.out.println("Segundo: " + produtoPedidoDTO.getPedido());

        // do same for Pedido 
        Pedido pedido = new Pedido();
        // pedido.setId(produtoPedidoDTO.getPedido());
        pedido = pedidoRepository.findById(produtoPedidoDTO.getPedido()).get();
        prodPedido.setPedido(pedido);

        prodPedido.setQuantidade(produtoPedidoDTO.getQuantidade());

        return produtoPedidoRepository.save(prodPedido);
    }