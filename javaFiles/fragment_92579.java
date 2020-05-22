Collection<Prospection> all = prospectionRepository.findAll().stream()
        .collect(Collectors.toMap(
                Prospect::getProspectNumber,
                Function.identity(),
                (oldProspect, newProspect) -> newProspect.getStatus() == MET ? newProspect : oldProspect
        )).values();
prospectionRepository.save(all);