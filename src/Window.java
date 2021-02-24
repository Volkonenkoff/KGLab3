import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;


public class Window extends JFrame {
    private JPanel contentPane;
    private JButton buttonRefresh;
    private JButton buttonLess;
    private JButton buttonMore;
    private JSlider rotationAngle;
    private JTextField aX;
    private JTextField aZ;
    private JTextField aY;
    private JTextField bX;
    private JTextField bZ;
    private JTextField bY;
    private JPanel display;
    private JPanel A;
    private JPanel B;
    private Cube CubeFigure;
    public Window() {
        setContentPane(contentPane);
        this.setMinimumSize(new Dimension(1280,720));
        this.setTitle("КГ №1 Вариант 6");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rotationAngle.setValue(0);
        rotationAngle.setToolTipText(String.valueOf(rotationAngle.getValue())+" °");
        rotationAngle.addChangeListener(e->{
            rotationAngle.setToolTipText(String.valueOf(rotationAngle.getValue())+" °");
        });


        JPanel Paint = new JPanel()
        {
          public void paintComponent(Graphics drawing)
          {
              Graphics2D drawing2D = (Graphics2D) drawing;
              drawing2D.setColor(Color.BLACK);
              drawing2D.fillRect(0, 0, display.getWidth(), display.getHeight());
              drawing2D.translate(display.getWidth() / 2, display.getHeight() / 2);
              drawing2D.setColor(Color.WHITE);

              CubeFigure=new Cube();

              Path2D path = new Path2D.Double();

              for (int i=0;i<CubeFigure.shapesArray.size();i++) {
                  Shapes temp=(Shapes)CubeFigure.shapesArray.get(i);
                  path.moveTo(temp.d1.x+temp.d1.y, temp.d1.y+temp.d1.z);
                  path.lineTo(temp.d2.x+temp.d2.y, temp.d2.y+temp.d2.z);
                  path.lineTo(temp.d3.x+temp.d3.y, temp.d3.y+temp.d3.z);
                  path.lineTo(temp.d4.x+temp.d4.y, temp.d4.y+temp.d4.z);
                  path.closePath();
                  drawing2D.draw(path);
              }
              path.closePath();

              drawing2D.draw(path);
          }

        };

        display.add(Paint);

    }


    public static void main(String[] args) {
        Window dialog = new Window();
        dialog.pack();
        dialog.setVisible(true);

    }


}
