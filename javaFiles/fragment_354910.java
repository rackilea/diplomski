return
create.select(sum(min(MYTABLE.NUM_VIEWS)).over())
      .from(MYTABLE)
      .groupBy(MYTABLE.ID)
      .limit(inline(1))
      .fetchSingle()
      .value1().longValue();