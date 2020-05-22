xyz: "XYZ"       ELT_SEP! 
     {ckt();}(xyz1_1a:ANUM|xyz1_1b:NUM)          {lq(90,xyz1_1a,xyz1_1b,"XYZ1-1"+LQ90)}?  ELT_SEP!
     {ckt();}(xyz1_2a:ANUM|xyz1_2b:NUM)?         {lq_(90,xyz1_2a,xyz1_2b,"XYZ1-2"+LQ90)}? ELT_SEP!
     {ckt();}(xyz1_3a:ANUM|xyz1_3b:NUM)?         {lq_(90,xyz1_3a,xyz1_3b,"XYZ1-3"+LQ90)}? ELT_SEP! 
     {ckt();}(xyz2a:ANUM|xyz2b:NUM)?             {lq_(3,xyz2a,xyz2b,"XYZ2"+LQ3)}?         ELT_SEP! 
     {ckt();}(xyz3a:ANUM|xyz3b:NUM)?             {lq_(6,xyz3a,xyz3b,"XYZ3"+LQ6)}?         ELT_SEP! 
     {ckt();}(xyz4a:ANUM|xyz4b:NUM)              {lq(30,xyz4a,xyz4b,"XYZ4"+LQ30)}?
     (ELT_SEP! {ckt();}(xyz5a:ANUM|xyz5b:NUM)?)?  {lq_(46,xyz5a,xyz5b,"XYZ5"+LQ46)}?       SEG_TERM!
     {
        if (skipNachricht()) return;
        Xyz xyz = new Xyz();
        xyz.xyz1_1 = getText(nn(xyz1_1a, xyz1_1b));
        xyz.xyz1_2 = getText(nn(xyz1_2a, xyz1_2b));
        xyz.xyz1_3 = getText(nn(xyz1_3a, xyz1_3b));
        xyz.xyz2 = getText(nn(xyz2a, xyz2b));
        xyz.xyz3 = getText(nn(xyz3a, xyz3b));
        xyz.xyz4 = getText(nn(xyz4a, xyz4b));
        xyz.xyz5 = getText(nn(xyz5a, xyz5b));
        handleXyz(xyz);
     }
   ;