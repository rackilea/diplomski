public void adicionarConfig(){
        if(this.listaConfig != null) {
           this.listaConfig.clear();
        }
        Configuracoes config = new Configuracoes( R.mipmap.ic_secure , "Conta", "Informações, Sala, Escola");
        this.listaConfig.add(config);

        config = new Configuracoes( R.mipmap.ic_config , "Layout", "Cor de fundo, Estilos, Propriedades");
        this.listaConfig.add(config);

        config = new Configuracoes( R.mipmap.ic_notification , "Notificação", "Tipo de notificação, ");
        this.listaConfig.add(config);

        config = new Configuracoes( R.mipmap.ic_about , "Sobre nós", null);
        this.listaConfig.add(config);

    }