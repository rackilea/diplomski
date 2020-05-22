import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String[][] deptarray;
    String[][] zonearray;
    String[][] roomarray;
    String[][] studsetarrayByCode;
    String[][] studsetarrayByTitle;
    String[][] staffarray;
    String[][] roombydeptarray;
    String[][] modulearrayByCode;
    String[][] modulearrayByTitle;
    String[][] progarrayByCode;
    String[][] progarrayByTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new RetrieveJSFileTask().execute("http://timetables.itsligo.ie:81/js/filter.js");
    }


    class RetrieveJSFileTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder builder = new StringBuilder();
                String line="";
                boolean store = false;

                builder.append("var deptarray;");
                builder.append("var zonearray;");

                while ((line = in.readLine()) != null) {

                    if(line.startsWith("var roomarray = ")||line.startsWith("var studsetarray =")||line.startsWith("var staffarray =")||line.startsWith("var roombydeptarray =")||line.startsWith("var modulearray =")||line.startsWith("var progarray =")){
                        builder.append(line);
                        continue;
                    }else if(line.contains("function PopulateFilter(strZoneOrDept, cbxFilter)")){ // populates dept and zone
                        store = true;
                    }
                    else if(line.contains("function FilterModulesByCode(Form) {") || line.contains("function FilterModulesByTitle(Form) {") ){ // populates module
                        store = true;
                    }
                    else if(line.contains("function FilterStudentSetsByCode(Form) {") || line.contains("function FilterStudentSetsByTitle(Form) {") ){ // populates studset
                        store = true;
                    }
                    else if(line.contains("function FilterRooms(Form) {") ){ // populates room
                        store = true;
                    }
                    else if(line.contains("function FilterRoomsByDept(Form) {") ){ // populates roombydept
                        store = true;
                    }
                    else if( line.contains("function FilterProgrammesByCode(Form) {") || line.contains("function FilterProgrammesByTitle(Form) {") ){ // populates prog
                        store = true;
                    }
                    else if(line.contains("function FilterStaff(Form) {") ){ // populates staff
                        store = true;
                    }
                    else if(line.contains("var zonearray") || line.contains("var deptarray") ){ // make zone and dept global
                        line = line.replace("var ", "");
                    }

                    if(store){
                        builder.append(line);
                    }

                    if( line.contains("zonearray.sort()") || line.contains("modulearray.sort();") || line.contains("studsetarray.sort();") || line.contains("roomarray.sort();") || line.contains(" roombydeptarray.sort();") || line.contains(" progarray.sort();") || line.contains("staffarray.sort();") ){
                        builder.append("return;}"); // stop function execution after population of arrays
                        store = false;
                        continue;
                    }
                }
                in.close();
                return builder.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(String jsSource) {

            if(jsSource==null) return;

            Context rhino = Context.enter();

            // Turn off optimization to make Rhino Android compatible
            rhino.setOptimizationLevel(-1);

            Scriptable scope = rhino.initStandardObjects();
            ScriptableObject.putProperty(scope, "javaContext", Context.javaToJS(this, scope));
            rhino.evaluateString(scope, jsSource, "ScriptAPI", 1, null);

            ((Function)scope.get("PopulateFilter", scope)).call(rhino, scope, scope, new Object[]{null,null});
            deptarray = getArray((NativeArray)scope.get("deptarray", scope));
            zonearray = getArray((NativeArray)scope.get("zonearray", scope));

            ((Function)scope.get("FilterModulesByCode", scope)).call(rhino, scope, scope, new Object[]{null});
            modulearrayByCode = getArray((NativeArray)scope.get("modulearray", scope));

            ((Function)scope.get("FilterModulesByTitle", scope)).call(rhino, scope, scope, new Object[]{null});
            modulearrayByTitle = getArray((NativeArray)scope.get("modulearray", scope));

            ((Function)scope.get("FilterStudentSetsByCode", scope)).call(rhino, scope, scope, new Object[]{null});
            studsetarrayByCode = getArray((NativeArray)scope.get("studsetarray", scope));

            ((Function)scope.get("FilterStudentSetsByTitle", scope)).call(rhino, scope, scope, new Object[]{null});
            studsetarrayByTitle = getArray((NativeArray)scope.get("studsetarray", scope));

            ((Function)scope.get("FilterRooms", scope)).call(rhino, scope, scope, new Object[]{null});
            roomarray = getArray((NativeArray)scope.get("roomarray", scope));

            ((Function)scope.get("FilterRoomsByDept", scope)).call(rhino, scope, scope, new Object[]{null});
            roombydeptarray = getArray((NativeArray)scope.get("roombydeptarray", scope));

            ((Function)scope.get("FilterProgrammesByCode", scope)).call(rhino, scope, scope, new Object[]{null});
            progarrayByCode = getArray((NativeArray)scope.get("progarray", scope));

            ((Function)scope.get("FilterProgrammesByTitle", scope)).call(rhino, scope, scope, new Object[]{null});
            progarrayByTitle = getArray((NativeArray)scope.get("progarray", scope));

            ((Function)scope.get("FilterStaff", scope)).call(rhino, scope, scope, new Object[]{null});
            staffarray = getArray((NativeArray)scope.get("staffarray", scope));

            printArray(deptarray, "deptarray");
            printArray(zonearray, "zonearray");
            printArray(modulearrayByCode, "modulearrayByCode");
            printArray(modulearrayByTitle, "modulearrayByTitle");
            printArray(studsetarrayByCode, "studsetarrayByCode");
            printArray(studsetarrayByTitle, "studsetarrayByTitle");
            printArray(roomarray, "roomarray");
            printArray(roombydeptarray, "roombydeptarray");
            printArray(progarrayByCode, "progarrayByCode");
            printArray(progarrayByTitle, "progarrayByTitle");
            printArray(staffarray, "staffarray");

            Context.exit();
        }

        private void printArray(String[][] array, String tag){
            String output = "";
            for(int row=0;row<array.length;row++){
                for(int column=0;column<array[row].length;column++){
                    output+=array[row][column]+"\n";
                }
            }
            Log.e( (tag==null?"JavaArray":tag),output);
        }

        private String[][] getArray(NativeArray nativeArray){
            String[][] javaArray = new String[nativeArray.size()][((NativeArray)nativeArray.get(0)).size()];
            for (Integer row : nativeArray.getIndexIds()) {
                for(int column=0;column<((NativeArray)nativeArray.get(row)).size();column++){
                    javaArray[row][column] = (String)((NativeArray) nativeArray.get(row)).get(column);
                }
            }
            return javaArray;
        }

    }

}