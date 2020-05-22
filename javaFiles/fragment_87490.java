public Banesa gjejBanese(int nrBaneses) {
    Banesa ret;
    for (int i = 0; i < listaBanesave.length; i++) {
        ret = listaBansesave[i];
        if (ret.getNrBanesa() == nrBaneses)
            return ret;
    }

    // No element found or list is empty
    return null;
}