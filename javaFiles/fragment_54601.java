arraypedidos = mRepositorio.findAllPedidos();

                if (mPedidosAdapter == null) {
                    mPedidosAdapter = new PedidosAdapter(getActivity(), arraypedidos);
                    listpedidos.setAdapter(mPedidosAdapter);
                } else {
                    mPedidosAdapter.setData(arraypedidos);
                }