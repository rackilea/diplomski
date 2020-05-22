Set<Long> set = customers.stream()
            .filter(c -> c.getTrack() != null)
            .map(c -> c.getTrack().getId())
            .collect(Collectors.toSet());

Set<CusomerTrack> tracksToSave = tracks.stream()
            .filter(track -> set.contains(track.getId())
            .collect(Collectors.toSet()));