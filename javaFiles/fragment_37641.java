MyModel reduced = modelList.stream().reduce(new MyModel(0, 0, 0, 0), (a, b) ->
                      new MyModel(a.getFirstCount() + b.getFirstCount(),
                                  a.getSecondCount() + b.getSecondCount(),
                                  a.getThirdCount() + b.getThirdCount(),
                                  a.getFourthCount() + b.getFourthCount()));
System.out.println(reduced.getFirstCount());
System.out.println(reduced.getSecondCount());
System.out.println(reduced.getThirdCount());
System.out.println(reduced.getFourthCount());