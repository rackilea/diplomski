List<Prospection> all = prospectionRepository.findAll().stream()
        // we instantiate here a Map<ProspectNumber, Prospect>
        // There is no need to have a Map<ProspectNumber, List<Propect>> 
        // as the merge function will do the sorting for us
        .collect(Collectors.toMap(
                // Key: use the prospect number
                prospect -> prospect.getProspectNumber(),
                // Value: use the propect object itself
                prospect -> prospect,
                // Merge function: two prospects with the same prospect number
                // are found: keep the one with the MET status or the first one
                (oldProspect, newProspect) -> {
                    if(oldProspect.getStatus() == MET){
                        return oldProspect;
                    } else if (newProspect.getStatus() == MET){
                        return newProspect;
                    } else{
                        // return the first one, arbitrary decision
                        return oldProspect;
                    }
                }
        ))
        // get map values only
        .values()
        // stream it in order to collect its as a List
        .stream()
        .collect(Collectors.toList());
prospectionRepository.save(all);