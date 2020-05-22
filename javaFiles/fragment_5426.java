final String PUBLIC_KEY_PEM = "MIIBtzCCASsGByqGSM44BAEwggEeAoGBAJLJRIrDdiwbB6iWZTWowprJB8QfbLK7\n"
                                        + "8OUCoj6Ot5nfEL5VDPcc0v1rCGQxmL+nijPQsxA0LTucBySlkj6AvGIdND6yY7Qx\n"
                                        + "OZYeP6UErByzVhmDNG2MIhK7SL36O3uutOJKr86aTiDxP8/zSUO8JPZHqtr2K2Cm\n"
                                        + "lY6LQpocGnZ/AhUAmA/eq9AcGaNAqbT6ebB3IE3qWKkCgYAuh3zCz9aTPJ8+D9to\n"
                                        + "6xjjE6SEqKM4EDaA8kpV/363ad8kZRLRmtxTGDpIKV/k4ebb94+4o6VEFJKTUH7t\n"
                                        + "7c5uj8Hnr+8scctFE85nXprpK/CmxvWIZRl0AWjz1/8hoaUX3ZcLz9QbOLk1deSS\n"
                                        + "BksFgKZQgoaNVY3PPq0pjNfdCAOBhQACgYEAkDATEoqoCXMOy/LK+TOBqXWu3Tex\n"
                                        + "kkBMTJxYHyhXqmBLvvkiwBX1wz0i58Zg0Qde4euHXrYwYzufBXeMZ9p3Wku7VIwD\n"
                                        + "4PfefBAZhzCJ+Dh937T/2dI/PqNIObZb28I7TXD/SQfwXurKDnGdl16LHmMcZ7bS\n"
                                        + "d6AFgUd73b+Obh8=\n";
KeyFactory.getInstance("DSA").generatePublic(new X509EncodedKeySpec(Base64.decode(PUBLIC_KEY_PEM)));