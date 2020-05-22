public ArrayList<Task> findTasksByDate(Date date) {
            ArrayList<Task> returnList = new ArrayList<Task>();
            while(i<taskMan.size()); {
            for (Task element: taskMan) {
                if (date.equals(taskMan.get(i).getDueDate())) {  
                   returnList.add(taskMan.get(i));
                return returnList;
                }
                return null;
            }
            i++;
        }
}