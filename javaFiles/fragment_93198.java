@Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.nomeMateria.setText(listaNomeM.get(position));

if(position < listaDisc.size() )
        holder.materiaM.setText(listaDisc.get(position));

if(position < listaProf.size() )
        holder.professor.setText(listaProf.get(position));
    }