public boolean equals(Object o) {
        ItemAdubacao adubacao = (ItemAdubacao) o;
        if (this.getTanque_id() == adubacao.getTanque_id() && (this.getProduto().equals(adubacao.getProduto()))) {
            return true;
        }
        return false;
    }