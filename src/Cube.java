import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cube {
    List shapesArray;
    Cube(){
        shapesArray=new ArrayList<>();
        shapesArray.add(new Shapes(new Dot(-50,50,50),
                new Dot(50,50,50),
                new Dot(50,-50,50),
                new Dot(-50,-50,50), Color.BLUE));
        shapesArray.add(new Shapes(new Dot(50,50,50),
                new Dot(50,50,-50),
                new Dot(50,-50,-50),
                new Dot(50,-50,50), Color.RED));
        shapesArray.add(new Shapes(new Dot(50,50,-50),
                new Dot(-50,50,-50),
                new Dot(-50,-50,-50),
                new Dot(50,-50,-50), Color.WHITE));
        shapesArray.add(new Shapes(new Dot(-50,50,-50),
                new Dot(-50,50,50),
                new Dot(-50,-50,50),
                new Dot(-50,-50,-50), Color.GREEN));
        shapesArray.add(new Shapes(new Dot(50,50,50),
                new Dot(50,50,-50),
                new Dot(-50,50,-50),
                new Dot(-50,50,50), Color.ORANGE));
        shapesArray.add(new Shapes(new Dot(50,-50,50),
                new Dot(50,-50,-50),
                new Dot(-50,-50,-50),
                new Dot(-50,-50,50), Color.YELLOW));
    }

}
