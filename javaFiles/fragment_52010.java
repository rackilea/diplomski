List<Labels> dbRecord = roleRecord.getLabels();
        List<Labels> userRecord = role.getLabels();

        // create Map from dbRecord
        Map<String, Labels> labelsByName = dbRecord.stream()
            .collect(Collectors.toMap(this::getCorrectedLabelName, i -> i));

        userRecord
            // for each of userRecord
            .forEach(userRecordLabel -> {
                // if in dbRecord, update dbRecord labels
                if(labelsByName.containsKey(getCorrectedLabelName(userRecordLabel))){
                    Labels dbRecordLabel = labelsByName.get(getCorrectedLabelName(userRecordLabel));
                    dbRecordLabel.setAccess(userRecordLabel.getAccess());
                    dbRecordLabel.setMatch(userRecordLabel.getMatch());

                    labelsByName.put(getCorrectedLabelName(userRecordLabel), dbRecordLabel);

                }else{// if not then add to map
                    labelsByName.put(getCorrectedLabelName(userRecordLabel), userRecordLabel);
                }
            });

        // final complete list
        Collection<Labels> updatedLabels = labelsByName.values();