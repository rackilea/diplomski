String result = template("#{errNo} -> #{c.simpleName} -> #{c.package.name}")
                .arg("errNo", 101)
                .arg("c", String.class)
                .fmt();


System.out.println(result);