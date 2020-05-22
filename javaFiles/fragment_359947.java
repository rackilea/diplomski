void glCog(float r0,float r1,float r2,float w,int n)    // shaft/inner/outer radiuses, width, tooths
    {
    int i;
    float a,da,x,y,c,s;
    float p[6][3],q[6][3];  // slice points
    // set z for slice points
    a=-0.5*w; for (i=0;i<3;i++){ p[i][2]=a; q[i][2]=a; }
    a=+0.5*w; for (i=3;i<6;i++){ p[i][2]=a; q[i][2]=a; }
    // init first slice
    q[0][0]= r0; q[5][0]= r0;
    q[0][1]=0.0; q[5][1]=0.0;
    q[1][0]= r1; q[4][0]= r1;
    q[1][1]=0.0; q[4][1]=0.0;
    q[2][0]= r2; q[3][0]= r2;
    q[2][1]=0.0; q[3][1]=0.0;
    // divide circle to 2*n slices
    da=2.0*M_PI/float(4*n);
    glBegin(GL_QUADS);
    for (a=0.0,i=0;i<=n;i++)
        {
        // points on circles at angle a
        c=cos(a); s=sin(a); a+=da;
        x=r0*c; y=r0*s; p[0][0]=x; p[5][0]=x;
                        p[0][1]=y; p[5][1]=y;
        x=r1*c; y=r1*s; p[1][0]=x; p[4][0]=x;
                        p[1][1]=y; p[4][1]=y;
        x=r2*c; y=r2*s; p[2][0]=x; p[3][0]=x;
                        p[2][1]=y; p[3][1]=y;
        // render tooth
        c=cos(a); s=sin(a); a+=da;
        glNormal3f(0.0,0.0,-1.0);   // -Z base
        glVertex3fv(p[0]);
        glVertex3fv(p[2]);
        glVertex3fv(q[2]);
        glVertex3fv(q[0]);
        glNormal3f(0.0,0.0,+1.0);   // +Z base
        glVertex3fv(p[3]);
        glVertex3fv(p[5]);
        glVertex3fv(q[5]);
        glVertex3fv(q[3]);
        glNormal3f(-c,-s,0.0);      // shaft circumference side
        glVertex3fv(p[5]);
        glVertex3fv(p[0]);
        glVertex3fv(q[0]);
        glVertex3fv(q[5]);
        glNormal3f(c,s,0.0);        // outter circumference side
        glVertex3fv(p[2]);
        glVertex3fv(p[3]);
        glVertex3fv(q[3]);
        glVertex3fv(q[2]);
        glNormal3f(-s,c,0.0);
        glVertex3fv(p[4]);
        glVertex3fv(p[3]);
        glVertex3fv(p[2]);
        glVertex3fv(p[1]);
        glNormal3f(s,-c,0.0);
        glVertex3fv(q[1]);
        glVertex3fv(q[2]);
        glVertex3fv(q[3]);
        glVertex3fv(q[4]);

        // points on circles at angle a
        c=cos(a); s=sin(a); a+=da;
        x=r0*c; y=r0*s; q[0][0]=x; q[5][0]=x;
                        q[0][1]=y; q[5][1]=y;
        x=r1*c; y=r1*s; q[1][0]=x; q[4][0]=x;
                        q[1][1]=y; q[4][1]=y;
        x=r2*c; y=r2*s; q[2][0]=x; q[3][0]=x;
                        q[2][1]=y; q[3][1]=y;
        // render gap
        c=cos(a); s=sin(a); a+=da;
        glNormal3f(0.0,0.0,-1.0);   // -Z base
        glVertex3fv(q[0]);
        glVertex3fv(q[1]);
        glVertex3fv(p[1]);
        glVertex3fv(p[0]);
        glNormal3f(0.0,0.0,+1.0);   // +Z base
        glVertex3fv(q[4]);
        glVertex3fv(q[5]);
        glVertex3fv(p[5]);
        glVertex3fv(p[4]);
        glNormal3f(-c,-s,0.0);      // shaft circumference side
        glVertex3fv(q[5]);
        glVertex3fv(q[0]);
        glVertex3fv(p[0]);
        glVertex3fv(p[5]);
        glNormal3f(c,s,0.0);        // outter circumference side
        glVertex3fv(q[1]);
        glVertex3fv(q[4]);
        glVertex3fv(p[4]);
        glVertex3fv(p[1]);
        }
    glEnd();
    }