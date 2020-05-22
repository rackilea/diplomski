while (filter.find()) {
        if (filter.group(1) != null) {
            this.ano = Integer.parseInt(filter.group(1));
        }
        if (filter.group(2) != null) {
            episodios.add(new Episodio(idSerie, temporada, Integer.parseInt(filter.group(2))));
        }
    }