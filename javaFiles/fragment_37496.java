public EquipamentoBean(){
    this.equipamentos = new EquipamentoDao().listaEquipamentos();
    this.tipos = new ArrayList<EquipamentoTipo>();
    for (Equipamento equipamento : equipamentos) {
        this.tipos.add(equipamento.getEquipamentoTipoId());
    }
}