rankList.getItems().addListener(new ListChangeListener<Rank>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Rank> c) {
                 while (c.next()) {
                     if (c.wasAdded()) {
                         List<? extends Rank> ranks = c.getAddedSubList();
                         Collections.sort(ranks, (Rank t, Rank t1)
                         -> Long.compare(t.getNumericalRankApproximation(),
                         t1.getNumericalRankApproximation()));
                         setValue(ranks.get(ranks.size()).getNumericalRankApproximation());
                         increment();
                     }
                 }
            }
        });