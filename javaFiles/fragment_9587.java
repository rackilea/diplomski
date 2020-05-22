public List<BaseObject> convertList(List inputList){
        List<BaseObject> baseList = new ArrayList<>();

        if (inputList != null && inputList.size() > 0)
            baseList.addAll(inputList);

        return baseList;
    }