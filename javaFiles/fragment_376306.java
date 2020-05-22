s.addBatch("CREATE TABLE category ( id  INT NOT NULL GENERATED ALWAYS AS IDENTITY \n" +
        "\t(START WITH 0, INCREMENT BY 1), title  VARCHAR(100), " +
        "\tCONSTRAINT category_pk_id PRIMARY KEY (id))\n" );
s.addBatch("CREATE TABLE task (id SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY \n" +
        "\t(START WITH 0, INCREMENT BY 1), title VARCHAR(100), cat_id INT, visible BOOLEAN, " +
        "deprecated BOOLEAN," +
        "\t CONSTRAINT task_pk_id PRIMARY KEY (id)," +
        "\t CONSTRAINT fk_cat_id FOREIGN KEY (cat_id)\n" +
        "\t REFERENCES category(id))");