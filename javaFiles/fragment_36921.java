TextView name,tel,mob;

public AdapterMoshtariItem(ArrayList<StructMoshtariItem> array,TextView txtInfoMoshtariName,TextView txtInfoMoshtariTel
                                    ,TextView txtInfoMoshtariMob) {
super(G.context, R.layout.moshtari_item, array);
this.name=txtInfoMoshtariName;
this.tel=txtInfoMoshtariTel;
this.mob=txtInfoMoshtariMob;
}