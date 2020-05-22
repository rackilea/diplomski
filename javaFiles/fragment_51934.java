public class CopyEncrypted extends Copy {   

    public EncryptionAwareFilterSet createEncryptionAwareFilterSet()
    {       
        EncryptionAwareFilterSet eafilterSet = new EncryptionAwareFilterSet();      
        getFilterSets().addElement( eafilterSet );      
        return eafilterSet;
    }   
}


public class EncryptionAwareFilterSet extends FilterSet{

    @Override
    public synchronized void readFiltersFromFile(File file)
            throws BuildException {
        log("EncryptionAwareFilterSet::reading filters",0);
        super.readFiltersFromFile(file);

        Vector<Filter> filts = getFilters();
        for (Iterator iterator = filts.iterator(); iterator.hasNext();) {
            Filter filter = (Filter) iterator.next();
            if ( filter.getToken().equalsIgnoreCase( "PASSWORD" ) ){
                filter.setValue( Encryptor.getEncryptedValue ( filter.getValue() )  );
            }
        }   
    }
}