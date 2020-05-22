private void doTest()
{
    Thread t = new Thread()
    {
        public void run()
        {
            runOne(2000);
            runOne(300);
            runOne(20000);
        }

        private void runOne(int num)
        {
            String start = "<DepartmentList>";
            String mid1 =  "<Department>\n" +
                            "<DeptID>";
            String mid2 = "</DeptID>\n" +
                            "<DeptDescription>Dept ";
            String mid3 = "</DeptDescription></Department>";
            String fin = "</DepartmentList>";

            StringBuffer sb = new StringBuffer();
            sb.append(start);
            for (int i=0; i< num; i++)
            {
                sb.append(mid1);
                sb.append(""+i);
                sb.append(mid2);
                sb.append(""+i);
                sb.append(mid3);
            }
            sb.append(fin);

            Pattern p = Pattern.compile(
            "<Department\\s*>\\s*<DeptID\\s*>([^<]*)</DeptID>\\s*<DeptDescription\\s*>([^<]*)</DeptDescription>\\s*</Department>");

            long startN = System.currentTimeMillis();

            DepartmentList d = new DepartmentList();
            List<Department> departments = d.DepartmentList;

            Matcher m = p.matcher(sb);
            while (m.find())
            {
                Department department = new Department();
                department.DeptID(m.group(1));
                department.DeptDescription(m.group(2));
                departments.add(department);
            }

            long endN = System.currentTimeMillis();

            Log.d("Departments", "parsed: " + departments.size() + " in " + (endN-startN) + " millis");
            Log.d("Departments", "lastone: " + departments.get(departments.size() -1)._DeptID + " desc: " + departments.get(departments.size() -1)._DeptDescription);

        }
    };
    t.start();
}

public class DepartmentList {
    public List<Department> DepartmentList =new ArrayList<Department>();
    public boolean FinishedPopulating = false;
}

public class Department {

    private String _DeptID ="";
    public String DeptID()
    {
        return _DeptID;
    }
    public void DeptID(String Value)
    {
        _DeptID = Value;
    }

    private String _DeptDescription ="";
    public String DeptDescription()
    {
        return _DeptDescription;
    }
    public void DeptDescription(String Value)
    {
        _DeptDescription = Value;
    }
}