gridview.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            try
            {
                ((myCustomAdapter)parent.getAdapter()).myMethod("new_param");
                ((GridView)v.getParent()).invalidateViews();

            } 
            catch (Exception e) {
                System.out.println("onItemClick Excpetion = " + e);
            }
        }
    });