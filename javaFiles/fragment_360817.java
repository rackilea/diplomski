public List<GlpiEntities> consultaEntidadPresencial(GlpiEntities gentities) 
{
    List<GlpiEntities> consulta = new ArrayList<GlpiEntities>();
    try 
    {
        cnn = Conectar.getInstace();
        ps  = cnn.prepareStatement(
                "SELECT\n" 
                + "glpi_entities.name,\n" 
                + "Sum(glpi_tickettasks.actiontime)/3600 AS Tiempo\n"
                + "FROM glpi_tickettasks\n" 
                + "INNER JOIN glpi_tickets ON glpi_tickets.id = glpi_tickettasks.tickets_id\n" 
                + "INNER JOIN glpi_entities ON glpi_tickets.entities_id = glpi_entities.id\n" 
                + "WHERE\n" + "glpi_tickettasks.date BETWEEN ? AND ? AND\n" + "glpi_tickettasks.taskcategories_id = 4\n" 
                + "GROUP BY\n" + "glpi_entities.name");
        ps.setDate(1, gentities.getfInicial());
        ps.setDate(2, gentities.getfFinal());
        rs = ps.executeQuery();
        while (rs.next()) 
        {
            GlpiEntities gtickets = new GlpiEntities();
            gtickets.setName(
                    rs.getString(1));
            gtickets.setTiempoPresencial(
                    rs.getDouble(2));

            consulta.add(gtickets);
        }
    }
    catch (NamingException ex) 
    {
        Logger.getLogger(TasksDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (SQLException ex)
    {
        Logger.getLogger(TasksDao.class.getName()).log(Level.SEVERE, null, ex);
    }

    return consulta;
}