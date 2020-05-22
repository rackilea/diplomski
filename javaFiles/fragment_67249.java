REGISTER \path\TrimCols.jar;

DEFINE TrimCols com.company.myproject.TrimCols();

A = LOAD '/path/file.txt' USING TextLoader() AS (line:chararray);
B = FOREACH A GENERATE TrimCols(line);
DUMP B;