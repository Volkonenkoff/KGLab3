package GraphiLab;

import javax.swing.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class Cover {

    protected Dot[][] Dots;
    protected Dot[][] originDots;

    Cover(){
        Dots=new Dot[6][4];
        originDots=new Dot[6][4];
        for (int i = 0; i < Dots.length; i++) {
            for (int j = 0; j < Dots[0].length; j++) {
                Dots[i][j]=new Dot(-200+i*55,0,-200+j*55);
                originDots[i][j]=new Dot(Dots[i][j].x,Dots[i][j].y,Dots[i][j].z);
            }
        }
    }
    public Path2D starting(){

        Path2D Cover = new Path2D.Double();
        try {
            ArrayList<Dot> coverDots = new ArrayList<>();

            for (double t = 0; t <= 1; t += 0.00125)
                for (double v=0; v <= 1; v +=0.5)
                    coverDots.add(buildBezier(t,v));
            Cover=draw(coverDots);

        }
        catch (RuntimeException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return Cover;
    }

    private Dot buildBezier(double t, double v) {
        double x = 0;
        double y = 0;
        double z = 0;

        int n = Dots.length-1;
        int m = Dots[0].length-1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                final var pow = Math.pow(1 - v, m - j);
                final var pow1 = Math.pow(1 - t, n - i);
                x += Math.pow(v,j)* pow *(fact(m) / (fact(j) * fact(m - j)))*
                        (fact(n) / (fact(i) * fact(n - i))) * Dots[i][j].x *
                        Math.pow(t, i) * pow1;
                y += Math.pow(v,j)* pow *(fact(m) / (fact(j) * fact(m - j)))*
                        (fact(n) / (fact(i) * fact(n - i))) * Dots[i][j].y *
                        Math.pow(t, i) * pow1;
                z += Math.pow(v,j)* pow *(fact(m) / (fact(j) * fact(m - j)))*
                        (fact(n) / (fact(i) * fact(n - i))) * Dots[i][j].z *
                        Math.pow(t, i) * pow1;
            }
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
    public Path2D draw(ArrayList<Dot> curvesDots) {
        double x1, y1, x2, y2;
        Path2D Drawing = new Path2D.Double();
        for (int i = 1; i < curvesDots.size(); i++) {
            x1 = curvesDots.get(i - 1).x;
            y1 = curvesDots.get(i - 1).y;
            x2 = curvesDots.get(i).x;
            y2 = curvesDots.get(i).y;
            Drawing.moveTo(x1, y1);
            Drawing.lineTo(x2, y2);
        }
        return Drawing;
    }

    public void rotation(){
        double[][] rot ={
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
        double[][] exp = new double[24][4];
        int r =0,l=0;
        for (int i=0;i<exp.length;i++)
        {

                exp[i][0]=Dots[l][r].x;
                exp[i][1]=Dots[l][r].y;
                exp[i][2]=Dots[l][r].z;
                exp[i][3]=1;

                if (r+1==4)
                {
                    r=0;
                    l++;
                } else r++;
        }
        double[][] res =new double[Dots.length* Dots[0].length][4];
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
        l=0;
        r=0;
        for (int i=0;i<exp.length;i++)
        {
            Dots[l][r].x=res[i][0];
            Dots[l][r].y=res[i][1];
            Dots[l][r].z=res[i][2];

            if (r+1==4)
            {
                r=0;
                l++;
            }else r++;
        }
    }

    public void projection()
    {
        double[][] rot ={
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
        double[][] exp = new double[Dots.length* Dots[0].length][4];
        int r =0,l=0;
        for (int i=0;i<exp.length;i++)
        {

            exp[i][0]=Dots[l][r].x;
            exp[i][1]=Dots[l][r].y;
            exp[i][2]=Dots[l][r].z;
            exp[i][3]=1;

            if (r+1==4)
            {
                r=0;
                l++;
            }else r++;
        }
        double[][] res =new double[Dots.length* Dots[0].length][4];
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
        l=0;
        r=0;
        for (int i=0;i<exp.length;i++)
        {
            Dots[l][r].x=res[i][0];
            Dots[l][r].y=res[i][1];
            Dots[l][r].z=res[i][2];

            if (r+1==4)
            {
                r=0;
                l++;
            }else r++;
        }

    }

    public void rotateShapeByAxis(Dot L, Dot L1, int sigma)
    {
        double N=Math.sqrt((L1.x-L.x)*(L1.x-L.x)+(L1.y-L.y)*(L1.y-L.y)+(L1.z-L.z)*(L1.z-L.z));
        double[] c ={(L1.x-L.x)/N,(L1.y-L.y)/N,(L1.z-L.z)/N};
        double d=Math.sqrt(c[2]*c[2]+c[1]*c[1]);
        double dSigma=sigma*Math.PI/180;
        double[][] exp = new double[Dots.length* Dots[0].length][4];
        int r =0,l=0;
        for (int i=0;i<exp.length;i++)
        {

            exp[i][0]=originDots[l][r].x;
            exp[i][1]=originDots[l][r].y;
            exp[i][2]=originDots[l][r].z;
            exp[i][3]=1;

            if (r+1==4)
            {
                r=0;
                l++;
            }else r++;
        }
        double[][] T = {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {-L.x,-L.y,-L.z,1}
        };
        double[][] T1 = {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {L.x,L.y,L.z,1}
        };
        double[][] Rx = {
                {1,0,0,0},
                {0,c[2]/d,c[1]/d,0},
                {0,-c[1]/d,c[2]/d,0},
                {0,0,0,1}
        };
        double[][] Ry = {
                {d,0,c[0],0},
                {0,1,0,0},
                {-c[0],0,d,0},
                {0,0,0,1}
        };
        double[][] Rs = {
                {Math.cos(dSigma),Math.sin(dSigma),0,0},
                {-Math.sin(dSigma),Math.cos(dSigma),0,0},
                {0,0,1,0},
                {0,0,0,1}
        };
        double[][] Rx1 = {
                {1,0,0,0},
                {0,c[2]/d,-c[1]/d,0},
                {0,c[1]/d,c[2]/d,0},
                {0,0,0,1}
        };
        double[][] Ry1 = {
                {d,0,-c[0],0},
                {0,1,0,0},
                {c[0],0,d,0},
                {0,0,0,1}
        };
        double[][] temp1 =new double[Dots.length* Dots[0].length][4];
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
        double[][] temp2 =new double[Dots.length* Dots[0].length][4];
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
        l=0;
        r=0;
        for (int i=0;i<exp.length;i++)
        {
            Dots[l][r].x=temp1[i][0];
            Dots[l][r].y=temp1[i][1];
            Dots[l][r].z=temp1[i][2];

            if (r+1==4)
            {
                r=0;
                l++;
            }else r++;
        }
    }
    public void rotationZ(int sigma){
        double dSigma=sigma*Math.PI/180;
        double[][] rot ={
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
        double[][] exp = new double[Dots.length* Dots[0].length][4];
        int r =0,l=0;
        for (int i=0;i<exp.length;i++)
        {

            exp[i][0]=originDots[l][r].x;
            exp[i][1]=originDots[l][r].y;
            exp[i][2]=originDots[l][r].z;
            exp[i][3]=1;

            if (r+1==4)
            {
                r=0;
                l++;
            } else r++;
        }

        double[][] res =new double[Dots.length* Dots[0].length][4];
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

        l=0;
        r=0;
        for (int i=0;i<exp.length;i++)
        {
            Dots[l][r].x=res[i][0];
            Dots[l][r].y=res[i][1];
            Dots[l][r].z=res[i][2];

            if (r+1==4)
            {
                r=0;
                l++;
            } else r++;
        }

    }
    public void rotationY(int sigma){
        double dSigma=sigma*Math.PI/180;
        double[][] rot ={
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
        double[][] exp = new double[Dots.length* Dots[0].length][4];
        int r =0,l=0;
        for (int i=0;i<exp.length;i++)
        {

            exp[i][0]=originDots[l][r].x;
            exp[i][1]=originDots[l][r].y;
            exp[i][2]=originDots[l][r].z;
            exp[i][3]=1;

            if (r+1==4)
            {
                r=0;
                l++;
            } else r++;
        }
        double[][] res =new double[Dots.length* Dots[0].length][4];
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

        l=0;
        r=0;
        for (int i=0;i<exp.length;i++)
        {
            Dots[l][r].x=res[i][0];
            Dots[l][r].y=res[i][1];
            Dots[l][r].z=res[i][2];

            if (r+1==4)
            {
                r=0;
                l++;
            } else r++;
        }

    }
    public void rotationX(int sigma){
        double dSigma=sigma*Math.PI/180;
        double[][] rot ={
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
        double[][] exp = new double[Dots.length* Dots[0].length][4];
        int r =0,l=0;
        for (int i=0;i<exp.length;i++)
        {

            exp[i][0]=originDots[l][r].x;
            exp[i][1]=originDots[l][r].y;
            exp[i][2]=originDots[l][r].z;
            exp[i][3]=1;

            if (r+1==4)
            {
                r=0;
                l++;
            } else r++;
        }
        double[][] res =new double[Dots.length* Dots[0].length][4];
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

        l=0;
        r=0;
        for (int i=0;i<exp.length;i++)
        {
            Dots[l][r].x=res[i][0];
            Dots[l][r].y=res[i][1];
            Dots[l][r].z=res[i][2];

            if (r+1==4)
            {
                r=0;
                l++;
            } else r++;
        }

    }
}
