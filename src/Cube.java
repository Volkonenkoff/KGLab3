import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube {
    List shapesArray;
    Cube(){
        Dot A=new Dot(0,1,1);
        Dot B=new Dot(0,1,0);
        Dot C=new Dot(1,1,0);
        Dot D=new Dot(1,1,1);
        Dot E=new Dot(0,0,1);
        Dot F=new Dot(0,0,1);
        Dot G=new Dot(1,0,0);
        Dot H=new Dot(1,0,1);
        shapesArray=new ArrayList<>();
        shapesArray.add(new Shapes(A,B,C,D));
        shapesArray.add(new Shapes(E,F,G,H));
        shapesArray.add(new Shapes(A,B,F,E));
        shapesArray.add(new Shapes(A,D,H,E));
        shapesArray.add(new Shapes(B,C,G,F));
        shapesArray.add(new Shapes(D,C,G,H));
    }

    public void RotateByNewAxis(Dot A, Dot B,int sigma )
    {
        double N=Math.sqrt((B.x-A.x)*(B.x-A.x)+(B.y-A.y)*(B.y-A.y)+(B.z-A.z)*(B.z-A.z));
        double c[]={(B.x-A.x)/N,(B.y-A.y)/N,(B.z-A.z)/N};
        double d=Math.sqrt(c[1]*c[1]+c[0]*c[0]);
        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);
            temp.rotateShapeByAxis(c,d,A,sigma);

        }
    }
    public void RotateByX(int sigma )
    {
        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);
            temp.rotationX(sigma);
            //temp.rotation();
            //temp.projection();
        }
    }
    public void RotateByY(int sigma )
    {
        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);
            temp.rotationY(sigma);
            //temp.rotation();
            //temp.projection();
        }
    }
    public void RotateByZ(int sigma )
    {
        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);
            temp.rotationZ(sigma);
           // temp.rotation();
            //temp.projection();
        }
    }

}
