WITH
  FUNCTION arttext_(
    p_art_id     in number
   ,p_arttextart in varchar2 default 'basis'
   ,p_sprache    in varchar2 default null
   ,p_aufart     in number   default null
   ,p_fallback_arttextart in number default 1
  ) RETURN VARCHAR2 IS BEGIN
    RETURN pa_bez.arttext(
      p_art_id, 
      p_arttextart, 
      p_sprache,
      p_aufart
      CASE p_fallback_arttextart WHEN 1 THEN TRUE WHEN 0 THEN FALSE ELSE NULL END
    );
  END arttext_;
SELECT arttext_(?, ?, ?, ?, ?) FROM dual