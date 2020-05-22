class AdapterAmcPersonalizada extends BaseAdapter {
        private AvailacaoMensal flag;
        private final List<AvaliacaoMensal> mensal;
        private final Activity act;


        public AdapterAmcPersonalizada(List<AvaliacaoMensal> mensal, Activity act) {
            this.mensal = mensal;
            this.act = act;

        }

        @Override
        public int getCount() {
            return mensal.size();
        }

        @Override
        public Object getItem(int position) {
            return mensal.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = act.getLayoutInflater().inflate(R.layout.activity_layout_lista_amc, parent, false);
            AvaliacaoMensal mensalAmc = mensal.get(position);



            //pegando as referências das Views
            TextView potencial = (TextView) view.findViewById(R.id.potencialLetra);
            TextView questao = (TextView) view.findViewById(R.id.questao);
            TextView titulo = (TextView) view.findViewById(R.id.titulo);

            //populando as Views
            potencial.setText(String.valueOf(mensalAmc.getPotencial()));
            questao.setText(String.valueOf(mensalAmc.getQuestao()));
            titulo.setText(String.valueOf(mensalAmc.getTitulo()));


           RadioGroup radioGroupAmc = (RadioGroup) view.findViewById(R.id.radioGroupAmc);

           flag = mensalAmc;
           radioGroupAmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {


                    switch(checkedId) {

                        case R.id.sim:
                                flag.radioButtonValues[0] = group.isChecked();
                                // trata radioValor1
                                break;
                        case R.id.nao:

                                // trata radioValor2
                                break;
                        case R.id.na:

                            // trata radioValor3
                            break;
                    }

                }
            });



            return view;
        }



    }