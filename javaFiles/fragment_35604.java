CREATE TABLE LevelsTable (
    levelType   VARCHAR(30)  NOT NULL,
    lowerLevel  INTEGER      NOT NULL,
    upperLevel  INTEGER      NULL,
    levelDesc   VARCHAR(30)  NOT NULL,
    CONSTRAINT PK_LevelsTable PRIMARY KEY ( levelType, lowerLevel )
);

INSERT INTO LevelsTable VALUES ( 'pushUps',  0, 10  , 'pathetic'  );
INSERT INTO LevelsTable VALUES ( 'pushUps', 10, 15  , 'very weak' );
INSERT INTO LevelsTable VALUES ( 'pushUps', 15, 20  , 'weak'      );
INSERT INTO LevelsTable VALUES ( 'pushUps', 20, 30  , 'average'   );
INSERT INTO LevelsTable VALUES ( 'pushUps', 30, 40  , 'good'      );
INSERT INTO LevelsTable VALUES ( 'pushUps', 40, NULL, 'very good' );
INSERT INTO LevelsTable VALUES ( 'age'    ,  0, 13  , 'child'     );
INSERT INTO LevelsTable VALUES ( 'age'    , 13, 20  , 'teenager'  );
INSERT INTO LevelsTable VALUES ( 'age'    , 20, 55  , 'adult'     );
INSERT INTO LevelsTable VALUES ( 'age'    , 55, NULL, 'senior'    );