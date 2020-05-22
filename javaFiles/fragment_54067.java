PropertyMap<Source, Target> personMap = new
            PropertyMap<Source, Target>() {
                protected void configure() {
                    map().setAnnual(source.getAnnual());

                    using(annualToMonthlyConverter).map(source.getAnnual(), destination.getMonthly());
                }
            };