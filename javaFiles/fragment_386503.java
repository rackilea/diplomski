val isEquals = hBaseJavaPairRDD
              .join(hiveJavaPairRDD)
              .map {
                case (id, (v1, v2)) => v1 == v2
              }
              .reduce(_ && _)