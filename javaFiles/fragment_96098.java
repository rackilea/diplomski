idProcesso.setCellValueFactory(data -> 
        new SimpleIntegerProperty(data.getValue().
                    getProcessoRodando().getId()).asObject());

tempoE.setCellValueFactory(data -> 
        new SimpleIntegerProperty(data.getValue().
                    getProcessoRodando().getTempoExecucaoRest()).asObject());