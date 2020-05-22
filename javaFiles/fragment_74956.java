if (Obj.getEmp == null)
    {
        cond_Map.entrySet().stream()
           .filter(entry -> "one".equals(entry.getKey())).forEach(entry -> {
            Obj.setEmp(entry.getValue());
        });
    }