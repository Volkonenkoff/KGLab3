import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube {
    List shapesArray;
    Cube(){
        Dot A=new Dot(-50,50,50);
        Dot B=new Dot(-50,-50,50);
        Dot C=new Dot(-50,-50,-50);
        Dot D=new Dot(-50,50,-50);
        Dot E=new Dot(50,50,50);
        Dot F=new Dot(50,-50,50);
        Dot G=new Dot(50,-50,-50);
        Dot H=new Dot(50,50,-50);
        shapesArray=new ArrayList<>();

        shapesArray.add(new Shapes(C,D,H,G));
        shapesArray.add(new Shapes(C,B,F,G));
        shapesArray.add(new Shapes(C,D,A,B));
        shapesArray.add(new Shapes(E,F,G,H));
        shapesArray.add(new Shapes(E,H,D,A));
        shapesArray.add(new Shapes(E,F,B,A));
    }

    public void RotateByNewAxis(Dot A, Dot B,int sigma )
    {
        double N=Math.sqrt((B.x-A.x)*(B.x-A.x)+(B.y-A.y)*(B.y-A.y)+(B.z-A.z)*(B.z-A.z));
        double c[]={(B.x-A.x)/N,(B.y-A.y)/N,(B.z-A.z)/N};
        double d=Math.sqrt(c[2]*c[2]+c[1]*c[1]);
        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);
            temp.rotateShapeByAxis(c,d,A,sigma);
            temp.rotation();
            temp.projection();

        }
    }
    public void RotateByX(int sigma )
    {
        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);
            temp.rotationX(sigma);
            temp.rotation();
            temp.projection();
        }
    }
    public void RotateByY(int sigma )
    {
        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);
            temp.rotationY(sigma);
            temp.rotation();
            temp.projection();
        }
    }
    public void RotateByZ(int sigma )
    {
        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);
            temp.rotationZ(sigma);
            temp.rotation();
            temp.projection();
        }
    }

}
