import java.awt.*;

public class Shapes {
    Dot d1;
    Dot d2;
    Dot d3;
    Dot d4;
    Dot originD1;
    Dot originD2;
    Dot originD3;
    Dot originD4;

    Shapes(Dot d1, Dot d2, Dot d3, Dot d4)
    {
        this.d1=d1;
        this.d2=d2;
        this.d3=d3;
        this.d4=d4;
        this.originD1=new Dot(this.d1.x,this.d1.y,this.d1.z);
        this.originD2=new Dot(this.d2.x,this.d2.y,this.d2.z);
        this.originD3=new Dot(this.d3.x,this.d3.y,this.d3.z);
        this.originD4=new Dot(this.d4.x,this.d4.y,this.d4.z);

    }
    public void rotationZ(int sigma){
        double dSigma=sigma*Math.PI/180;
        double rot[][]={
                {
                        Math.cos(dSigma), Math.sin(dSigma), 0,0
                },
                {
                        -Math.sin(dSigma), Math.cos(dSigma), 0,0
                },
                {
                        0,0,1,0
                },
                {
                        0,0,0,1
                }
        };
        double exp[][]={
                {
                        originD1.x, originD1.y, originD1.z, 1
                },
                {
                        originD2.x,originD2.y,originD2.z,1
                },
                {
                        originD3.x,originD3.y,originD3.z,1
                },
                {
                        originD4.x,originD4.y,originD4.z,1
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
    public void rotationY(int sigma){
        double dSigma=sigma*Math.PI/180;
        double rot[][]={
                {
                        Math.cos(dSigma), 0, -Math.sin(dSigma),0
                },
                {
                        0, 1, 0,0
                },
                {
                        Math.sin(dSigma),0,Math.cos(dSigma),0
                },
                {
                        0,0,0,1
                }
        };
        double exp[][]={
                {
                        originD1.x, originD1.y, originD1.z, 1
                },
                {
                        originD2.x,originD2.y,originD2.z,1
                },
                {
                        originD3.x,originD3.y,originD3.z,1
                },
                {
                        originD4.x,originD4.y,originD4.z,1
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
    public void rotationX(int sigma){
        double dSigma=sigma*Math.PI/180;
        double rot[][]={
                {
                        1, 0, 0,0
                },
                {
                        0, Math.cos(-dSigma), Math.sin(-dSigma),0
                },
                {
                        0,-Math.sin(-dSigma),Math.cos(-dSigma),0
                },
                {
                        0,0,0,1
                }
        };
        double exp[][]={
                {
                        originD1.x, originD1.y, originD1.z, 1
                },
                {
                        originD2.x,originD2.y,originD2.z,1
                },
                {
                        originD3.x,originD3.y,originD3.z,1
                },
                {
                        originD4.x,originD4.y,originD4.z,1
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
    public void rotation(){
        double rot[][]={
                {
                        0.925820 , 0.133631 , - 0.353553,0
                },
                {
                        0, 0.935414 , 0.353553,0
                },
                {
                        0.377964,-0.327329,0.866025 ,0
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
    public void rotateShapeByAxis(double c[],double d, Dot A, int sigma)
    {

        double dSigma=sigma*Math.PI/180;
        double exp[][]={
                {
                        originD1.x, originD1.y, originD1.z, 1
                },
                {
                        originD2.x,originD2.y,originD2.z,1
                },
                {
                        originD3.x,originD3.y,originD3.z,1
                },
                {
                        originD4.x,originD4.y,originD4.z,1
                }
        };
        double T[][]= {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {-A.x,-A.y,-A.z,1}
        };
        double T1[][]= {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {A.x,A.y,A.z,1}
        };
        double Rx[][]= {
                {1,0,0,0},
                {0,c[2]/d,c[1]/d,0},
                {0,-c[1]/d,c[2]/d,0},
                {0,0,0,1}
        };
        double Ry[][]= {
                {d,0,c[0],0},
                {0,1,0,0},
                {-c[0],0,d,0},
                {0,0,0,1}
        };
        double Rs[][]= {
                {Math.cos(dSigma),Math.sin(dSigma),0,0},
                {-Math.sin(dSigma),Math.cos(dSigma),0,0},
                {0,0,1,0},
                {0,0,0,1}
        };
        double Rx1[][]= {
                {1,0,0,0},
                {0,c[2]/d,-c[1]/d,0},
                {0,c[1]/d,c[2]/d,0},
                {0,0,0,1}
        };
        double Ry1[][]= {
                {d,0,-c[0],0},
                {0,1,0,0},
                {c[0],0,d,0},
                {0,0,0,1}
        };
        double temp1[][]=new double[4][4];
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<T[0].length;j++)
            {
                temp1[i][j]=0;
                for(int k=0; k<T[0].length;k++)
                {
                    temp1[i][j]=temp1[i][j]+exp[i][k]*T[k][j];
                }
            }
        }
        double temp2[][]=new double[4][4];
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<T[0].length;j++)
            {
                temp2[i][j]=0;
                for(int k=0; k<T[0].length;k++)
                {
                    temp2[i][j]=temp2[i][j]+temp1[i][k]*Rx[k][j];
                }
            }

        }
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<T[0].length;j++)
            {
                temp1[i][j]=0;
                for(int k=0; k<T[0].length;k++)
                {
                    temp1[i][j]=temp1[i][j]+temp2[i][k]*Ry[k][j];
                }
            }
        }
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<T[0].length;j++)
            {
                temp2[i][j]=0;
                for(int k=0; k<T[0].length;k++)
                {
                    temp2[i][j]=temp2[i][j]+temp1[i][k]*Rs[k][j];
                }
            }
        }
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<T[0].length;j++)
            {
                temp1[i][j]=0;
                for(int k=0; k<T[0].length;k++)
                {
                    temp1[i][j]=temp1[i][j]+temp2[i][k]*Ry1[k][j];
                }
            }
        }
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<T[0].length;j++)
            {
                temp2[i][j]=0;
                for(int k=0; k<T[0].length;k++)
                {
                    temp2[i][j]=temp2[i][j]+temp1[i][k]*Rx1[k][j];
                }
            }
        }
        for (int i=0;i<exp[0].length;i++)
        {
            for(int j=0; j<T[0].length;j++)
            {
                temp1[i][j]=0;
                for(int k=0; k<T[0].length;k++)
                {
                    temp1[i][j]=temp1[i][j]+temp2[i][k]*T1[k][j];
                }
            }
        }
        d1.x=temp1[0][0];
        d1.y=temp1[0][1];
        d1.z=temp1[0][2];
        d2.x=temp1[1][0];
        d2.y=temp1[1][1];
        d2.z=temp1[1][2];
        d3.x=temp1[2][0];
        d3.y=temp1[2][1];
        d3.z=temp1[2][2];
        d4.x=temp1[3][0];
        d4.y=temp1[3][1];
        d4.z=temp1[3][2];
    }
}
