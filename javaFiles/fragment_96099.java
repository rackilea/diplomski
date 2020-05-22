idProcesso.setCellValueFactory(data -> {
        Processo processo = data.getValue().getProcessoRodando();
        return new SimpleObjectProperty<Integer>(processo != null ?
            Integer.valueOf(processo.getId()) : null);
    });

tempoE.setCellValueFactory(data -> {
        Processo processo = data.getValue().getProcessoRodando();
        return new SimpleObjectProperty<Integer>(processo != null ?
            Integer.valueOf(processo.getTempoExecucaoRest()) : null);
    });