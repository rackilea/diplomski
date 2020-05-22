Comparator<MyClass> comparator = Ordering.natural().reverse().onResultOf(new Function<MyClass, Boolean>() {
        @Override
        public Boolean apply(MyClass myClass) {
            return isActive(myClass);
        }
    })
    .compound(Ordering.from(DateTimeComparator.getInstance()).nullsFirst().onResultOf(new Function<MyClass, Date>() {
        @Override
        public Date apply(MyClass myClass) {
            return isActive(myClass) ? myClass.startDate : myClass.endDate;
        }
    }))
    .nullsFirst();