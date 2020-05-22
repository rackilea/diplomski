@OneToMany(fetch=FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
        @Where(clause="is_deleted <> '1'")
        @JsonIgnore
        public Set<Ad> getAds() {
            return ads;
        }