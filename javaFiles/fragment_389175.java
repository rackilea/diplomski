ServiceA serviceA= ServiceA.create();
 ServiceA serviceB= ServiceB.create();

 serviceA.checkObjectExists(id)
         .flatMap(exists -> {
                if(exists) {
                    return serviceB.addObjectB(id, b)
                } else {
                    return serviceA.addObjectA(id, a).flatMap(newA -> serviceB.addObject(id, newA);
                }

         })
         .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe();