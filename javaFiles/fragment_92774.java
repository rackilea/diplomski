void picture::smooth(int n)
    {
    color   *q0,*q1;
    int     x,y,i,c0[4],c1[4],c2[4];
    bool _signed;
    if ((xs<2)||(ys<2)) return;
    for (;n>0;n--)
        {
        #define loop_beg for (y=0;y<ys-1;y++){ q0=p[y]; q1=p[y+1]; for (x=0;x<xs-1;x++) { dec_color(c0,q0[x],pf); dec_color(c1,q0[x+1],pf); dec_color(c2,q1[x],pf);
        #define loop_end enc_color(c0,q0[x  ],pf); }}
        if (pf==_pf_rgba) loop_beg for (i=0;i<4;i++) { c0[i]=(c0[i]+c0[i]+c1[i]+c2[i])>>2; clamp_u8(c0[i]);  } loop_end
        if (pf==_pf_s   ) loop_beg                   { c0[0]=(c0[0]+c0[0]+c1[0]+c2[0])/ 4; clamp_s32(c0[0]); } loop_end
        if (pf==_pf_u   ) loop_beg                   { c0[0]=(c0[0]+c0[0]+c1[0]+c2[0])>>2; clamp_u32(c0[0]); } loop_end
        if (pf==_pf_ss  ) loop_beg for (i=0;i<2;i++) { c0[i]=(c0[i]+c0[i]+c1[i]+c2[i])/ 4; clamp_s16(c0[i]); } loop_end
        if (pf==_pf_uu  ) loop_beg for (i=0;i<2;i++) { c0[i]=(c0[i]+c0[i]+c1[i]+c2[i])>>2; clamp_u16(c0[i]); } loop_end
        #undef loop_beg
        #define loop_beg for (y=ys-1;y>0;y--){ q0=p[y]; q1=p[y-1]; for (x=xs-1;x>0;x--) { dec_color(c0,q0[x],pf); dec_color(c1,q0[x-1],pf); dec_color(c2,q1[x],pf);
        if (pf==_pf_rgba) loop_beg for (i=0;i<4;i++) { c0[i]=(c0[i]+c0[i]+c1[i]+c2[i])>>2; clamp_u8(c0[i]);  } loop_end
        if (pf==_pf_s   ) loop_beg                   { c0[0]=(c0[0]+c0[0]+c1[0]+c2[0])/ 4; clamp_s32(c0[0]); } loop_end
        if (pf==_pf_u   ) loop_beg                   { c0[0]=(c0[0]+c0[0]+c1[0]+c2[0])>>2; clamp_u32(c0[0]); } loop_end
        if (pf==_pf_ss  ) loop_beg for (i=0;i<2;i++) { c0[i]=(c0[i]+c0[i]+c1[i]+c2[i])/ 4; clamp_s16(c0[i]); } loop_end
        if (pf==_pf_uu  ) loop_beg for (i=0;i<2;i++) { c0[i]=(c0[i]+c0[i]+c1[i]+c2[i])>>2; clamp_u16(c0[i]); } loop_end
        #undef loop_beg
        #undef loop_end
        }
    }