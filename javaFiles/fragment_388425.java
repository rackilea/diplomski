CREATE OR REPLACE DIRECTORY xml_template_dir
  AS '/path/to/oracle/apps/xdo/oa/schema/server/';
/

CREATE JAVA CLASS USING BFILE (xml_template_dir, 'TemplateHelper.class' )
/