import java.util.ArrayList;

public class TestApp {

    public static void main(String[] args){

        String[][] data = 
        {{"Datos Varios", "Datos Empresa", null}, 
        {"Listado2", "Listado2 extendido", null}, 
        {"Pendientes Validar", "Pendientes Liquidar", "Liquidados"},
        {"Pendientes Aprobar", "Pendientes Pago", "Pagados"}};

        String[][] cleanedData = removeNull(data);

        System.out.println("Before");
        printArray(data);
        System.out.println("after");
        printArray( cleanedData );
    }

    public static void printArray(String[][] arr2d){
        for(String[] arr1d: arr2d){
            for(String s: arr1d){
                System.out.print(s+", ");
            }
            System.out.print("\n");
        }
    }

    public static String[][] removeNull( String[][] arr2d) {
        //
        ArrayList<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
        //
        for(String[] arr1d: arr2d){
            ArrayList<String> list1d = new ArrayList<String>();
            for(String s: arr1d){
                if(s != null && s.length() > 0) {
                    list1d.add(s);
                }
            }
            // you will possibly not want empty arrays in your 2d array
            // so I removed them
            if(list1d.size()>0){
                list2d.add(list1d);
            }
        }
        String[][] cleanArr = new String[list2d.size()][];
        int next = 0;
        for(ArrayList<String> list1d: list2d){
            cleanArr[next++] = list1d.toArray(new String[list1d.size()]);
        }
        return cleanArr;
    }
}