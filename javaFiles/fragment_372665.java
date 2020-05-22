@Override
public void updateParameters(Map<LocalSetting.SettingType, LocalSetting> parameters) 
{

    for (Map.Entry<String, String> entry : map.entrySet())
    {
        sessionFactory.getCurrentSession().update(entry.getValue());
    }
    sessionFactory.getCurrentSession().commit();
    sessionFactory.getCurrentSession().close();  
}