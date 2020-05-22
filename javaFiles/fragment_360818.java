if (null != request.getParameter("entidad")
        && request.getParameter("entidad").equals("Enviar"))
{
    String fInicial = request.getParameter("inicial");
    String fFinal   = request.getParameter("final");

    if (fInicial.length() < 19
            || fFinal.length() < 19) 
    {
        response.sendRedirect(
                "reportes/Reportegeneral.jsp?msg=Las fechas deben ser ingresadas con el formato Año-Mes-Día horas-minutos-segundos.");
    }
    else
    {
        GlpiEntities entities = new GlpiEntities();
        try {
            Date inicial = formatter.parse(fInicial);
            Date fechaF  = formatter.parse(fFinal);
            fi = new java.sql.Date(
                    inicial.getTime());
            ff = new java.sql.Date(
                    fechaF.getTime());
            entities.setfInicial(fi);
            entities.setfFinal(ff);
            List<GlpiEntities> presencial = tdao.consultaEntidadPresencial(entities);
            List<GlpiEntities> remoto     = tdao.consultaEntidadRemoto(entities);
            List<GlpiEntities> resultado  = new ArrayList<GlpiEntities>();

            List<GlpiEntities> largerList = presencial.size() > remoto.size() ? presencial : remoto;
            List<GlpiEntities> smallerList = presencial.size() > remoto.size() ? remoto : presencial;

            if (presencial.size() == remoto.size())
            {
                largerList  = presencial;
                smallerList = remoto;
            }

            /** temporary values */
            boolean      exists = false;
            GlpiEntities tremote = null;

            for (GlpiEntities presential : presencial)
            {
                exists  = false;
                tremote = null ;

                for (GlpiEntities remote : remoto) 
                {
                    if (presential.getName().equals(remote.getName()))
                    {
                        exists  = true;
                        tremote = remote;
                        break;
                    }
                    /*
                    if (!presential.getName().equals(remote.getName())) 
                    {
                        //out.print(" <br/> el valor de primer if es: "+presential.getName());
                        resultado.add(presential);
                    } 
                    else if (presential.getName().equals(
                                remote.getName())) 
                    {
                        presential.setTiempoRemoto(
                                remote.getTiempoRemoto());
                        //out.print(" <br/> el valor de primer if es: "+presential.getName()+" Valor de remoto"+remote.getName());
                        resultado.add(presential);
                    }
                    */
                    if (exists)
                    {
                        presential.setTiempoRemoto(
                                tremote.getTiempoRemoto());
                    }
                    resultado.add(presential);
                }
            }

            for (GlpiEntities remote : remoto) 
            {
                exists  = false;    

                for (GlpiEntities presential : presencial)
                {
                    if (remote.getName().equals(presential.getName()))
                    {
                        exists = true;
                        break;
                    }
                }

                if (!exists)
                {
                    resultado.add(presential);
                }
            }

            for (GlpiEntities listado : resultado) 
            {
                out.print(" <br/> Nombre entidad: "    + listado.getName());
                out.print(" <br/> Tiempo Presencial: " + listado.getTiempoPresencial());
                out.print(" <br/> Tiempo Remoto: "     + listado.getTiempoRemoto());
            }

            sesion.setAttribute("entidaddetalle", resultado);
            response.sendRedirect("reportes/Reportegeneral.jsp?resul=ok"); 
        } 
        catch (ParseException ex) 
        {
            Logger.getLogger(
                    ReporteCtrol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}