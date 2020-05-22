List<Venues.Category> clone = categoryList.stream().collect(Collectors.toList());
                clone.remove(i);
                clone.add(i, modifyCategory(category, countryAbbr, gasStationConfig));

                builder.clearCategory();
                builder.addAllCategory(clone);