package ApoyoBeans;

import Pojos.Asociados;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Gustavo
 */
public class LazyDataModelUsuarios extends LazyDataModel<Asociados> {

    private final List<Asociados> datasource;

    public LazyDataModelUsuarios(List<Asociados> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Asociados getRowData(String rowKey) {
        for(Asociados asoc : datasource) {
            if(asoc.getNroaccionista().toString().equals(rowKey)){
                return asoc;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Asociados aso) {
        return aso.getNroaccionista().toString();
    }

    @Override
    public List<Asociados> load(int first, int pageSize, String sortField,     SortOrder sortOrder, Map<String,Object> filters) {
        List<Asociados> data = new ArrayList<Asociados>();

        //filter
        System.out.println("Filtros:" + filters);

        for(Asociados asoc : this.datasource) {
            boolean match = true;

            //System.out.println(filters);

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator();   it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        //String fieldValue =  asoc.getClass().getField(filterProperty).toString();
                        //String fieldValue = asoc.getRazonSocial();
                        //String fieldValue = (String)  asoc.getClass().getDeclaredField(filterProperty).get(asoc);
                        //String fieldValue =  String.valueOf(asoc.getClass().getDeclaredField(filterProperty).get(asoc));



                        Field miembroPrivado =  asoc.getClass().getDeclaredField(filterProperty);
                        miembroPrivado.setAccessible(true);
                        String fieldValue = String.valueOf(miembroPrivado.get(asoc));






                        //System.out.println("Valor de fieldValue:" + fieldValue);


                        if(filterValue == null ||   fieldValue.startsWith(filterValue.toString().toUpperCase())) {
                            //System.out.println("Valor de filterValue.toString" + filterValue.toString());
                            //System.out.println("Valor de fieldValue" + fieldValue);
                            match = true;
                        }
                        else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                        match = false;
                    }
                }
            }

            if(match) {
                data.add(asoc);
            }
        }

        //sort
        //if(sortField != null) {
        //    Collections.sort(data, new LazySorter(sortField, sortOrder));
        //}

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}