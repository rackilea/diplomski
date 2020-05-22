CREATE TABLE tblPart(PartNumber nvarchar(15) PRIMARY KEY NOT NULL,
PartDescription nvarchar(150) NOT NULL);

CREATE TABLE tblStock(PartNumber nvarchar(15)  REFERENCES
tblPart(PartNumber) ON DELETE CASCADE ON UPDATE CASCADE NOT NULL,
StockOH integer NOT NULL);