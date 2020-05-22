volumeResources.sort(new Comparator<VolumeResource>() {
        @Override
        public int compare(VolumeResource v1, VolumeResource v2) {
            return v1.getDate().compareTo(v2.getDate());
        }
    });