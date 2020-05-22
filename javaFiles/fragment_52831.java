public boolean foiEditadoNesteSeculo () {
        return this.ano > 2000;
    }

    public void adicionaTemasBonus(int x) {
        this.temas += x;
    }

    public void mostraAlbum() {
        System.out.println(this.Titulo + " (editado em " + this.ano + "; tem " + this.temas + " temas)" );
    }