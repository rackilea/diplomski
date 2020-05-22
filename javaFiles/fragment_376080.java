ArrayList<Integer> selectedStatusId = new ArrayList<>();
    if (true){
        selectedStatusId.add(mStatuses.get(i).StatusId);
    } else {
        //  delete the first occurrence of the specified element from array
        selectedStatusId.remove(new Integer(mStatuses.get(i).StatusId));
    }