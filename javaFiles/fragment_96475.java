Query q = exp.createNativeQuery
          (
              "SELECT IESTATUT, IINICIO FROM \n SATTET0  WHERE IESTATUT=:1 AND DATAFIM IS NULL",
              SATTET0Key.class
          );

q.setParameter(1, estatuto);