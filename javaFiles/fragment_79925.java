public class ProfileCollection implements Iterable<Profile> { 
    private ArrayList<Profile> m_Profiles;

    public Iterator<Profile> iterator() {        
        Iterator<Profile> iprof = m_Profiles.iterator();
        return iprof; 
    }

    ...

    public Profile GetActiveProfile() {
        return (Profile)m_Profiles.get(m_ActiveProfile);
    }
}