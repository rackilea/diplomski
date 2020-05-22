with tab1 as (
        select 'Dept 1' dept, 'Store 1' store, 'Region 1' region, 'ASmith' id, 101 salary,  1 overtime, 10 adjusted from dual union all
        select 'Dept 1' dept, 'Store 1' store, 'Region 1' region, 'BSmith' id, 102 salary,  2 overtime, 10 adjusted from dual union all
        select 'Dept 1' dept, 'Store 2' store, 'Region 1' region, 'CSmith' id, 104 salary,  4 overtime, 10 adjusted from dual union all
        select 'Dept 1' dept, 'Store 2' store, 'Region 1' region, 'DSmith' id, 108 salary,  8 overtime, 10 adjusted from dual union all
        select 'Dept 1' dept, 'Store 3' store, 'Region 1' region, 'DSmith' id, 108 salary,  8 overtime, 10 adjusted from dual union all
        select 'Dept 2' dept, 'Store 1' store, 'Region 1' region, 'DSmith' id, 108 salary,  8 overtime, 10 adjusted from dual union all
        select 'Dept 2' dept, 'Store 1' store, 'Region 1' region, 'ESmith' id, 116 salary, 16 overtime, 10 adjusted from dual union all
        select 'Dept 2' dept, 'Store 2' store, 'Region 1' region, 'FSmith' id, 132 salary, 32 overtime, 10 adjusted from dual union all
        select 'Dept 2' dept, 'Store 2' store, 'Region 1' region, 'ESmith' id, 116 salary, 16 overtime, 10 adjusted from dual union all
        select 'Dept 2' dept, 'Store 3' store, 'Region 1' region, 'FSmith' id, 132 salary, 32 overtime, 10 adjusted from dual
      )
select dept, store, region, sum(salary), sum(overtime), sum(adjusted)
  from tab1
 group by rollup(dept, store, region);