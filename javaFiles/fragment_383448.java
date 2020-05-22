Query condition = new Query(
        new Criteria()
        .orOperator(
            Criteria.where("imageShared.rateMedia.rateVal1").exists(true),
            Criteria.where("imageShared.rateMedia.rateVal2").exists(true)
        )
    );