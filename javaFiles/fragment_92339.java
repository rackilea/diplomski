private SubRegionEntity subRegion;

        @ManyToOne
        @JoinColumn(name="fk_SubRegionId",nullable=false)
        public SubRegionEntity getSubRegion() {
            return subRegion;
        }

        public void setSubRegion(SubRegionEntity subRegion) {
            this.subRegion = subRegion;
        }