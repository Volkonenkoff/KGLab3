import javax.swing.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Line {

    ArrayList<Dot> Dots;
    ArrayList<Dot> originDots;
    Line(Dot A, Dot B, Dot C, Dot D,Dot E,Dot F){
        Dots=new ArrayList<>();
        originDots=new ArrayList<>();
        Dots.add(A);
        Dots.add(B);
        Dots.add(C);
        Dots.add(D);
        Dots.add(E);
        Dots.add(F);
        originDots.add(new Dot(A.x,A.y,A.z));
        originDots.add(new Dot(B.x,B.y,B.z));
        originDots.add(new Dot(C.x,C.y,C.z));
        originDots.add(new Dot(D.x,D.y,D.z));
        originDots.add(new Dot(E.x,E.y,E.z));
        originDots.add(new Dot(F.x,F.y,F.z));

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
                        Dots.get(0).x, Dots.get(0).y, Dots.get(0).z, 1
                },
                {
                        Dots.get(1).x,Dots.get(1).y,Dots.get(1).z,1
                },
                {
                        Dots.get(2).x,Dots.get(2).y,Dots.get(2).z,1
                },
                {
                        Dots.get(3).x,Dots.get(3).y,Dots.get(3).z,1
                },
                {
                        Dots.get(4).x,Dots.get(4).y,Dots.get(4).z,1
                },
                {
                        Dots.get(5).x,Dots.get(5).y,Dots.get(5).z,1
                }

        };
        double res[][]=new double[6][4];
        for (int i=0;i<exp.length;i++)
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

        Dots.get(0).x=res[0][0];
        Dots.get(0).y=res[0][1];
        Dots.get(0).z=res[0][2];
        Dots.get(1).x=res[1][0];
        Dots.get(1).y=res[1][1];
        Dots.get(1).z=res[1][2];
        Dots.get(2).x=res[2][0];
        Dots.get(2).y=res[2][1];
        Dots.get(2).z=res[2][2];
        Dots.get(3).x=res[3][0];
        Dots.get(3).y=res[3][1];
        Dots.get(3).z=res[3][2];
        Dots.get(4).x=res[4][0];
        Dots.get(4).y=res[4][1];
        Dots.get(4).z=res[4][2];
        Dots.get(5).x=res[5][0];
        Dots.get(5).y=res[5][1];
        Dots.get(5).z=res[5][2];



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
                        Dots.get(0).x, Dots.get(0).y, Dots.get(0).z, 1
                },
                {
                        Dots.get(1).x,Dots.get(1).y,Dots.get(1).z,1
                },
                {
                        Dots.get(2).x,Dots.get(2).y,Dots.get(2).z,1
                },
                {
                        Dots.get(3).x,Dots.get(3).y,Dots.get(3).z,1
                },
                {
                        Dots.get(4).x,Dots.get(4).y,Dots.get(4).z,1
                },
                {
                        Dots.get(5).x,Dots.get(5).y,Dots.get(5).z,1
                }

        };
        double res[][]=new double[6][4];
        for (int i=0;i<exp.length;i++)
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
        Dots.get(0).x=res[0][0];
        Dots.get(0).y=res[0][1];
        Dots.get(0).z=res[0][2];
        Dots.get(1).x=res[1][0];
        Dots.get(1).y=res[1][1];
        Dots.get(1).z=res[1][2];
        Dots.get(2).x=res[2][0];
        Dots.get(2).y=res[2][1];
        Dots.get(2).z=res[2][2];
        Dots.get(3).x=res[3][0];
        Dots.get(3).y=res[3][1];
        Dots.get(3).z=res[3][2];
        Dots.get(4).x=res[4][0];
        Dots.get(4).y=res[4][1];
        Dots.get(4).z=res[4][2];
        Dots.get(5).x=res[5][0];
        Dots.get(5).y=res[5][1];
        Dots.get(5).z=res[5][2];

    }

    public void rotateShapeByAxis(Dot L, Dot L1, int sigma)
    {
        double N=Math.sqrt((L1.x-L.x)*(L1.x-L.x)+(L1.y-L.y)*(L1.y-L.y)+(L1.z-L.z)*(L1.z-L.z));
        double c[]={(L1.x-L.x)/N,(L1.y-L.y)/N,(L1.z-L.z)/N};
        double d=Math.sqrt(c[2]*c[2]+c[1]*c[1]);
        double dSigma=sigma*Math.PI/180;
        double exp[][]={
                {
                        originDots.get(0).x, originDots.get(0).y, originDots.get(0).z, 1
                },
                {
                        originDots.get(1).x,originDots.get(1).y,originDots.get(1).z,1
                },
                {
                        originDots.get(2).x,originDots.get(2).y,originDots.get(2).z,1
                },
                {
                        originDots.get(3).x,originDots.get(3).y,originDots.get(3).z,1
                },
                {
                        originDots.get(4).x,originDots.get(4).y,originDots.get(4).z,1
                },
                {
                        originDots.get(5).x,originDots.get(5).y,originDots.get(5).z,1
                }

        };
        double T[][]= {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {-L.x,-L.y,-L.z,1}
        };
        double T1[][]= {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {L.x,L.y,L.z,1}
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
        double temp1[][]=new double[6][4];
        for (int i=0;i<exp.length;i++)
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
        double temp2[][]=new double[6][4];
        for (int i=0;i<exp.length;i++)
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
        for (int i=0;i<exp.length;i++)
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
        for (int i=0;i<exp.length;i++)
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
        for (int i=0;i<exp.length;i++)
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
        for (int i=0;i<exp.length;i++)
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
        for (int i=0;i<exp.length;i++)
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
        Dots.get(0).x=temp1[0][0];
        Dots.get(0).y=temp1[0][1];
        Dots.get(0).z=temp1[0][2];
        Dots.get(1).x=temp1[1][0];
        Dots.get(1).y=temp1[1][1];
        Dots.get(1).z=temp1[1][2];
        Dots.get(2).x=temp1[2][0];
        Dots.get(2).y=temp1[2][1];
        Dots.get(2).z=temp1[2][2];
        Dots.get(3).x=temp1[3][0];
        Dots.get(3).y=temp1[3][1];
        Dots.get(3).z=temp1[3][2];
        Dots.get(4).x=temp1[4][0];
        Dots.get(4).y=temp1[4][1];
        Dots.get(4).z=temp1[4][2];
        Dots.get(5).x=temp1[5][0];
        Dots.get(5).y=temp1[5][1];
        Dots.get(5).z=temp1[5][2];
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
                        originDots.get(0).x, originDots.get(0).y, originDots.get(0).z, 1
                },
                {
                        originDots.get(1).x,originDots.get(1).y,originDots.get(1).z,1
                },
                {
                        originDots.get(2).x,originDots.get(2).y,originDots.get(2).z,1
                },
                {
                        originDots.get(3).x,originDots.get(3).y,originDots.get(3).z,1
                },
                {
                        originDots.get(4).x,originDots.get(4).y,originDots.get(4).z,1
                },
                {
                        originDots.get(5).x,originDots.get(5).y,originDots.get(5).z,1
                }

        };

        double res[][]=new double[6][4];
        for (int i=0;i<exp.length;i++)
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

        Dots.get(0).x=res[0][0];
        Dots.get(0).y=res[0][1];
        Dots.get(0).z=res[0][2];
        Dots.get(1).x=res[1][0];
        Dots.get(1).y=res[1][1];
        Dots.get(1).z=res[1][2];
        Dots.get(2).x=res[2][0];
        Dots.get(2).y=res[2][1];
        Dots.get(2).z=res[2][2];
        Dots.get(3).x=res[3][0];
        Dots.get(3).y=res[3][1];
        Dots.get(3).z=res[3][2];
        Dots.get(4).x=res[4][0];
        Dots.get(4).y=res[4][1];
        Dots.get(4).z=res[4][2];
        Dots.get(5).x=res[5][0];
        Dots.get(5).y=res[5][1];
        Dots.get(5).z=res[5][2];

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
                        originDots.get(0).x, originDots.get(0).y, originDots.get(0).z, 1
                },
                {
                        originDots.get(1).x,originDots.get(1).y,originDots.get(1).z,1
                },
                {
                        originDots.get(2).x,originDots.get(2).y,originDots.get(2).z,1
                },
                {
                        originDots.get(3).x,originDots.get(3).y,originDots.get(3).z,1
                },
                {
                        originDots.get(4).x,originDots.get(4).y,originDots.get(4).z,1
                },
                {
                        originDots.get(5).x,originDots.get(5).y,originDots.get(5).z,1
                }

        };
        double res[][]=new double[6][4];
        for (int i=0;i<exp.length;i++)
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

        Dots.get(0).x=res[0][0];
        Dots.get(0).y=res[0][1];
        Dots.get(0).z=res[0][2];
        Dots.get(1).x=res[1][0];
        Dots.get(1).y=res[1][1];
        Dots.get(1).z=res[1][2];
        Dots.get(2).x=res[2][0];
        Dots.get(2).y=res[2][1];
        Dots.get(2).z=res[2][2];
        Dots.get(3).x=res[3][0];
        Dots.get(3).y=res[3][1];
        Dots.get(3).z=res[3][2];
        Dots.get(4).x=res[4][0];
        Dots.get(4).y=res[4][1];
        Dots.get(4).z=res[4][2];
        Dots.get(5).x=res[5][0];
        Dots.get(5).y=res[5][1];
        Dots.get(5).z=res[5][2];

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
                        originDots.get(0).x, originDots.get(0).y, originDots.get(0).z, 1
                },
                {
                        originDots.get(1).x,originDots.get(1).y,originDots.get(1).z,1
                },
                {
                        originDots.get(2).x,originDots.get(2).y,originDots.get(2).z,1
                },
                {
                        originDots.get(3).x,originDots.get(3).y,originDots.get(3).z,1
                },
                {
                        originDots.get(4).x,originDots.get(4).y,originDots.get(4).z,1
                },
                {
                        originDots.get(5).x,originDots.get(5).y,originDots.get(5).z,1
                }

        };
        double res[][]=new double[6][4];
        for (int i=0;i<exp.length;i++)
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

        Dots.get(0).x=res[0][0];
        Dots.get(0).y=res[0][1];
        Dots.get(0).z=res[0][2];
        Dots.get(1).x=res[1][0];
        Dots.get(1).y=res[1][1];
        Dots.get(1).z=res[1][2];
        Dots.get(2).x=res[2][0];
        Dots.get(2).y=res[2][1];
        Dots.get(2).z=res[2][2];
        Dots.get(3).x=res[3][0];
        Dots.get(3).y=res[3][1];
        Dots.get(3).z=res[3][2];
        Dots.get(4).x=res[4][0];
        Dots.get(4).y=res[4][1];
        Dots.get(4).z=res[4][2];
        Dots.get(5).x=res[5][0];
        Dots.get(5).y=res[5][1];
        Dots.get(5).z=res[5][2];

    }
    public Path2D starting(){

        Path2D Curve = new Path2D.Double();
        try {
            ArrayList<Dot> curvesDots = new ArrayList<>();

            for (double t = 0; t <= 1; t += 0.01)
                curvesDots.add(buildBezier(t));
            Curve=draw(curvesDots);
        }
        catch (RuntimeException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return Curve;
    }

    private Dot buildBezier(double t) {
        double x = 0;
        double y = 0;
        double z = 0;

        int n = Dots.size()-1;
        for (int i = 0; i <= n; i++) {
            x += fact(n) / (fact(i) * fact(n - i)) * Dots.get(i).x *
                    Math.pow(t, i) * Math.pow(1 - t, n - i);
            y += fact(n) / (fact(i) * fact(n - i)) * Dots.get(i).y *
                    Math.pow(t, i) * Math.pow(1 - t, n - i);
            z += fact(n) / (fact(i) * fact(n - i)) * Dots.get(i).z *
                    Math.pow(t, i) * Math.pow(1 - t, n - i);
        }
        return new Dot(x, y, z);
    }
    private double fact(double arg) throws RuntimeException {
        if (arg < 0) throw new RuntimeException("Некорректный аргумент при вычислении факториала");
        if (arg == 0) return 1;

        double res = 1;
        for (int i=1; i<=arg; i++)
            res *= i;
        return res;
    }
    public Path2D draw(ArrayList<Dot> curvesDots)
    {
        double x1,y1,x2,y2;
        Path2D Drawing = new Path2D.Double();
        for (int i = 1; i < curvesDots.size(); i++)
        {
            x1 = curvesDots.get(i-1).x;
            y1 = curvesDots.get(i-1).y;
            x2 = curvesDots.get(i).x;
            y2 = curvesDots.get(i).y;
            Drawing.moveTo(x1,y1);
            Drawing.lineTo(x2,y2);
        }
        return Drawing;
    }
}
