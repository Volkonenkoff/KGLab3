import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube {
    List shapesArray;
    Cube(){
        shapesArray=new ArrayList<>();
        shapesArray.add(new Shapes(new Dot(-1,1,1),
                new Dot(1,1,1),
                new Dot(1,-1,1),
                new Dot(-1,-1,1)));
        shapesArray.add(new Shapes(new Dot(1,1,1),
                new Dot(1,1,-1),
                new Dot(1,-1,-1),
                new Dot(1,-1,1)));
        shapesArray.add(new Shapes(new Dot(1,1,-1),
                new Dot(-1,1,-1),
                new Dot(-1,-1,-1),
                new Dot(1,-1,-1)));
        shapesArray.add(new Shapes(new Dot(-1,1,-1),
                new Dot(-1,1,1),
                new Dot(-1,-1,1),
                new Dot(-1,-1,-1)));
        shapesArray.add(new Shapes(new Dot(1,1,1),
                new Dot(1,1,-1),
                new Dot(-1,1,-1),
                new Dot(-1,1,1)));
        shapesArray.add(new Shapes(new Dot(1,-1,1),
                new Dot(1,-1,-1),
                new Dot(-1,-1,-1),
                new Dot(-1,-1,1)));
    }
    public void CubePointOfView()
    {

        for (int i=0;i<shapesArray.size();i++) {
            Shapes temp=(Shapes)shapesArray.get(i);



        }
    }
    public void RotateByNewAxis()
    {

    }

}
