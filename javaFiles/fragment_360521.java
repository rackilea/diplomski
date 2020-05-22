select deptno from
  ( select deptno, rownum as rn from
      ( select DISTINCT deptno
        from   emp
        order by deptno
      )
    where rownum < :pagenum*100
  )
where rn > (:pagenum-1)*100;