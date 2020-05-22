boolean      exists  = false;
 GlpiEntities tremote = null ;

 for (GlpiEntities presential: presencial){
     exists  = false;
     tremote = null ;
     for(GlpiEntities remote: remoto){
         if(presential.getName().equals(remote.getName())){
             exists  = true;
             tremote = remote;
             break;                                                 
         }
     }
     if (exists) {
         presential.setTiempoRemoto(tremote.getTiempoRemoto());
         //out.print(" <br/> el valor de primer if es: "+presential.getName()+" Valor de remoto"+remote.getName());
     }
     resultado.add(presential);

     for(GlpiEntities listado: resultado){
         out.print(" <br/> Nombre entidad: "+listado.getName());
         out.print(" <br/> Tiempo Presencial: "+listado.getTiempoPresencial());
         out.print(" <br/> Tiempo Remoto: "+listado.getTiempoRemoto());
     }
 }

 for(GlpiEntities remote: remoto){
     exists  = false;
     for (GlpiEntities presential: presencial){
         if(remote.getName().equals(presential.getName())){
             exists  = true;
             break;                                                 
         }
     }
     if (!exists) {
         resultado.add(presential);
     }

     for(GlpiEntities listado: resultado){
         out.print(" <br/> Nombre entidad: "+listado.getName());
         out.print(" <br/> Tiempo Presencial: "+listado.getTiempoPresencial());
         out.print(" <br/> Tiempo Remoto: "+listado.getTiempoRemoto());
     }
 }