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
                new Dot(-1,-1,1), Color.WHITE));
        shapesArray.add(new Shapes(new Dot(1,1,1),
                new Dot(1,1,-1),
                new Dot(1,-1,-1),
                new Dot(1,-1,1),Color.CYAN));
        shapesArray.add(new Shapes(new Dot(1,1,-1),
                new Dot(-1,1,-1),
                new Dot(-1,-1,-1),
                new Dot(1,-1,-1),Color.RED));
        shapesArray.add(new Shapes(new Dot(-1,1,-1),
                new Dot(-1,1,1),
                new Dot(-1,-1,1),
                new Dot(-1,-1,-1),Color.GREEN));
        shapesArray.add(new Shapes(new Dot(1,1,1),
                new Dot(1,1,-1),
                new Dot(-1,1,-1),
                new Dot(-1,1,1),Color.ORANGE));
        shapesArray.add(new Shapes(new Dot(1,-1,1),
                new Dot(1,-1,-1),
                new Dot(-1,-1,-1),
                new Dot(-1,-1,1),Color.YELLOW));
    }

    public void RotateByNewAxis()
    {

        for (int i=0;i<this.shapesArray.size();i++) {
            Shapes temp = (Shapes) this.shapesArray.get(i);

        }
    }

}
