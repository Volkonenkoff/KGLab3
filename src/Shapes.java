import java.awt.*;

public class Shapes {
    Dot d1;
    Dot d2;
    Dot d3;
    Dot d4;

    Shapes(Dot d1, Dot d2, Dot d3, Dot d4)
    {
        this.d1=d1;
        this.d2=d2;
        this.d3=d3;
        this.d4=d4;
    }

    public void rotation(){
        double rot[][]={
                {
                  Math.cos(3.14/4), Math.sin(0.62)*Math.sin(3.14/4), -Math.sin(3.14/4)*Math.cos(0.62),0
                },
                {
                    0, Math.cos(0.62), Math.sin(0.62),0
                },
                {
                    Math.sin(3.14/4),-Math.sin(0.62)*Math.cos(3.14/4),Math.cos(0.62)*Math.cos(3.14/4),0
                },
                {
                    0,0,0,1
                }
        };
        double exp[][]={
                {
                    d1.x, d1.y, d1.z, 1
                },
                {
                    d2.x,d2.y,d2.z,1
                },
                {
                    d3.x,d3.y,d3.z,1
                },
                {
                    d4.x,d4.y,d4.z,1
                }
        };
        double res[][]=new double[4][4];
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<rot[0].length;j++)
            {
                res[i][j]=0;
                for(int k=0; k<rot[0].length;k++)
                {
                    res[i][j]=res[i][j]+exp[i][k]*rot[k][j];
                }
            }

        }

        d1.x=res[0][0];
        d1.y=res[0][1];
        d1.z=res[0][2];
        d2.x=res[1][0];
        d2.y=res[1][1];
        d2.z=res[1][2];
        d3.x=res[2][0];
        d3.y=res[2][1];
        d3.z=res[2][2];
        d4.x=res[3][0];
        d4.y=res[3][1];
        d4.z=res[3][2];

    }
    public void projection()
    {
        double rot[][]={
                {
                    1,0,0,0
                },
                {
                    0,1,0,0
                },
                {
                    0,0,0,0
                },
                {
                    0,0,0,1
                }
        };
        double exp[][]={
                {
                        d1.x, d1.y, d1.z, 1
                },
                {
                        d2.x,d2.y,d2.z,1
                },
                {
                        d3.x,d3.y,d3.z,1
                },
                {
                        d4.x,d4.y,d4.z,1
                }
        };
        double res[][]=new double[4][4];
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<rot[0].length;j++)
            {
                res[i][j]=0;
                for(int k=0; k<rot[0].length;k++)
                {
                    res[i][j]=res[i][j]+exp[i][k]*rot[k][j];
                }
            }

        }

        d1.x=res[0][0];
        d1.y=res[0][1];
        d1.z=res[0][2];
        d2.x=res[1][0];
        d2.y=res[1][1];
        d2.z=res[1][2];
        d3.x=res[2][0];
        d3.y=res[2][1];
        d3.z=res[2][2];
        d4.x=res[3][0];
        d4.y=res[3][1];
        d4.z=res[3][2];
    }
}
