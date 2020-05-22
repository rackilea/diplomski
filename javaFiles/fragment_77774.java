public List<Task> getTaskDue(){     
    List<Task> temp = new ArrayList<Task>();

    for(int u = 0; u < unitCollection.size(); u++){
        Unit unit = unitCollection.get(u);

        for (int a = 0; a < unit.getAssessmentCollection().size(); a++){
            AssessmentItem assessment = unit.getAssessmentCollection().get(a);

            for (int t = 0; t < assessment.getTasks().size(); t++){
                Task task = assessment.getTasks().get(t);

                if (task.getDueDate().compareTo(assessment.getDueDate()) <= 0){ 
                    temp.add(task);
                }   
            }   
        }   
    }   
    return temp;
}