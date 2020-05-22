@Override
        public int getItemCount() {
    int listSize;

    listSize = listaProf.size()

    if(listSize < listaNomeM.size())
    listSize = listaNomeM.size()

    if(listSize < listaDisc .size())
       listSize = listaDisc.size()

            return listSize;
        }