return getData()
            .handle((d, e) -> {
                if (e == null) {
                    return Either.right(d);
                }
                return Either.left(ErrorResponse.create(e));
            });
}