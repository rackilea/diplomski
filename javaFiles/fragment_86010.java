EOrderByType orderType = EOrderByType.values()[orderBy];                    
                Expression<Object> queryCase = cb.selectCase().when(cb.isNull(root.get("price")), 100000000).otherwise(root.get("price"));
                Direction dir = Direction.ASC;

                switch (orderType) {
                    case UCUZDAN_PAHALIYA:
                        queryCase = cb.selectCase().when(cb.isNull(root.get("price")), 100000000).otherwise(root.get("price"));
                        break;
                    case PAHALIDAN_UCUZA:
                        queryCase = cb.selectCase().when(cb.isNull(root.get("price")), 0).otherwise(root.get("price"));
                        dir = Direction.DESC;
                        break;
                }

                  cq.where(predicate).orderBy(direction( cb, queryCase, dir));