import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;


public class Window extends JFrame {
    private JPanel contentPane;
    protected  JPanel Paint;
    private JButton buttonRefresh;
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
    private JPanel rot;
    protected Line Curve;
    private Axis X;
    private Axis Y;
    private Axis Z;
    private Axis newAxis;
    public Window() {
        setContentPane(contentPane);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setMaximumSize(new Dimension(1280, 720));
        this.setResizable(false);
        this.setTitle("КГ №2 Вариант 7");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        newAxis = new Axis(new Dot(0, 0, 0), new Dot(1, 0, 0));

        rotationAngle.setToolTipText(String.valueOf(rotationAngle.getValue()) + " °");

        Curve = new Line(new Dot(-100, -200, 200),
                new Dot(-50, -100, 125),
                new Dot(-10, -50, 50),
                new Dot(0, 0, 0),
                new Dot(30, 125, 125),
                new Dot(100, 200, 200));
        Curve.rotation();
        Curve.projection();


        aX.setText(String.valueOf(newAxis.A.x));
        aY.setText(String.valueOf(newAxis.A.y));
        aZ.setText(String.valueOf(newAxis.A.z));
        bX.setText(String.valueOf(newAxis.B.x));
        bY.setText(String.valueOf(newAxis.B.y));
        bZ.setText(String.valueOf(newAxis.B.z));
        X = new Axis(new Dot(0, 0, 0),
                new Dot(1, 0, 0));

        Y = new Axis(new Dot(0, 0, 0),
                new Dot(0, 1, 0));
        Z = new Axis(new Dot(0, 0, 0),
                new Dot(0, 0, 1));

        X.rotation();
        X.projection();
        Y.rotation();
        Y.projection();
        Z.rotation();
        Z.projection();
        newAxis.rotation();
        newAxis.projection();

        Paint = new JPanel() {
            public void paintComponent(Graphics drawing) {
                Graphics2D drawing2D = (Graphics2D) drawing;
                drawing2D.setColor(Color.BLACK);
                drawing2D.fillRect(0, 0, 720, 720);
                drawing2D.translate(360, 360);
                drawing2D.setColor(Color.DARK_GRAY);

                Path2D path = new Path2D.Double();
                Path2D dotPath = new Path2D.Double();
                Path2D axisPath = new Path2D.Double();
                Path2D newAxisPath = new Path2D.Double();

                axisPath.moveTo(X.A.x, X.A.y);
                axisPath.lineTo(X.B.x * 500, X.B.y * 500);
                axisPath.lineTo(-X.B.x * 500, -X.B.y * 500);
                axisPath.moveTo(Y.A.x, Y.B.y);
                axisPath.lineTo(Y.B.x * 500, Y.B.y * 500);
                axisPath.lineTo(-Y.B.x * 500, -Y.B.y * 500);
                axisPath.moveTo(Z.A.x, Z.B.y);
                axisPath.lineTo(Z.B.x * 500, Z.B.y * 500);
                axisPath.lineTo(-Z.B.x * 500, -Z.B.y * 500);
                axisPath.moveTo(0, 0);
                axisPath.closePath();
                drawing2D.draw(axisPath);
                drawing2D.setColor(Color.CYAN);
                newAxisPath.moveTo(newAxis.A.x, newAxis.A.y);
                newAxisPath.lineTo(newAxis.B.x, newAxis.B.y);
                newAxisPath.closePath();
                drawing2D.draw(newAxisPath);
                drawing2D.setColor(Color.RED);
                drawing2D.draw(Curve.starting());
                drawing2D.setColor(Color.CYAN);
                for (int i = 0; i < Curve.Dots.size(); i++) {
                    drawing2D.drawOval((int) Curve.Dots.get(i).x, (int) Curve.Dots.get(i).y, 5, 5);
                    dotPath.moveTo(Curve.Dots.get(i).x, Curve.Dots.get(i).y);


                }
                drawing2D.setColor(Color.BLUE);
                double x1, x2, y1, y2;
                for (int i = 1; i < Curve.Dots.size(); i++) {
                    x1 = Curve.Dots.get(i - 1).x;
                    y1 = Curve.Dots.get(i - 1).y;
                    x2 = Curve.Dots.get(i).x;
                    y2 = Curve.Dots.get(i).y;
                    path.moveTo(x1, y1);
                    path.lineTo(x2, y2);
                }
                drawing2D.draw(path);
            }

        };

        buttonRefresh.addActionListener(e -> {
            try {
                if (aX.getText().equals("") || aY.getText().equals("") ||
                        aZ.getText().equals("") || bX.getText().equals("") ||
                        bY.getText().equals("") || bZ.getText().equals("")
                )
                    throw new NullPointerException();
                if (Math.abs(Double.parseDouble(aX.getText())) > 250 || Math.abs(Double.parseDouble(aY.getText())) > 250 ||
                        Math.abs(Double.parseDouble(aZ.getText())) > 250 || Math.abs(Double.parseDouble(bX.getText())) > 250 ||
                        Math.abs(Double.parseDouble(bY.getText())) > 250 || Math.abs(Double.parseDouble(bZ.getText())) > 250
                )
                    throw new IllegalArgumentException();
                if (Double.parseDouble(aX.getText()) == Double.parseDouble(bX.getText()) &&
                        Double.parseDouble(aY.getText()) == Double.parseDouble(bY.getText()) &&
                        Double.parseDouble(aZ.getText()) == Double.parseDouble(bZ.getText())
                )
                    throw new IllegalStateException();
                newAxis.A.x = Double.parseDouble(aX.getText());
                newAxis.A.y = Double.parseDouble(aY.getText());
                newAxis.A.z = Double.parseDouble(aZ.getText());
                newAxis.B.x = Double.parseDouble(bX.getText());
                newAxis.B.y = Double.parseDouble(bY.getText());
                newAxis.B.z = Double.parseDouble(bZ.getText());
                newAxis.originA.x = Double.parseDouble(aX.getText());
                newAxis.originA.y = Double.parseDouble(aY.getText());
                newAxis.originA.z = Double.parseDouble(aZ.getText());
                newAxis.originB.x = Double.parseDouble(bX.getText());
                newAxis.originB.y = Double.parseDouble(bY.getText());
                newAxis.originB.z = Double.parseDouble(bZ.getText());
                newAxis.rotation();
                newAxis.projection();
                Paint.repaint();
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Пустое поле", "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Точки должны быть от -250.0 до 250.0",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, "Точки не должны быть одинаковыми",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        display.add(Paint);
        rotationAngle.addChangeListener(e -> {
            rotationAngle.setToolTipText(String.valueOf(rotationAngle.getValue()) + " °");
            if (newAxis.originA.y == 0 && newAxis.originA.z == 0 && newAxis.originB.y == 0 && newAxis.originB.z == 0)
                Curve.rotationX(rotationAngle.getValue());
            else if (newAxis.originA.x == 0 && newAxis.originA.z == 0 && newAxis.originB.x == 0 && newAxis.originB.z == 0)
                Curve.rotationY(rotationAngle.getValue());
            else if (newAxis.originA.y == 0 && newAxis.originA.x == 0 && newAxis.originB.y == 0 && newAxis.originB.x == 0)
                Curve.rotationZ(rotationAngle.getValue());
            else Curve.rotateShapeByAxis(newAxis.originA, newAxis.originB, rotationAngle.getValue());
            Curve.rotation();
            Curve.projection();
            Paint.repaint();
        });
        Paint.addMouseMotionListener(new Mouse());

    }

    private class Mouse implements MouseMotionListener {

        int rad;
        int k=-1;
        boolean beingDragged=false;
        @Override
        public void mouseDragged(MouseEvent e)
        {
            if (beingDragged==true)
            {
                beingDragged=false;
            }

            for (int i = 0; i<Curve.Dots.size() && !beingDragged; i++)
            {
                rad=(int)Math.sqrt((Math.pow(Curve.Dots.get(i).x-(double)(e.getX()-360),2)+Math.pow((Curve.Dots.get(i).y-(double)(e.getY()-360)),2)));
                if(rad<=40)
                {
                    beingDragged=true;
                    k=i;
                }
            }
            if (beingDragged==true)
            {
                do
                {
                    if(Math.abs(Curve.Dots.get(k).x)<360)
                    {
                        Curve.Dots.get(k).x = e.getX() - 360;
                        Curve.originDots.get(k).x=e.getX()-360;
                    }
                    else if (Curve.Dots.get(k).x>0 && Math.abs(Curve.Dots.get(k).x)>=360){
                        Curve.Dots.get(k).x=325;
                        Curve.originDots.get(k).x=325;
                    }
                    else if (Curve.Dots.get(k).x<0 && Math.abs(Curve.Dots.get(k).x)>=360){
                        Curve.Dots.get(k).x = -325;
                        Curve.originDots.get(k).x=-325;
                    }
                    if(Math.abs(Curve.Dots.get(k).y)<360) {
                        Curve.Dots.get(k).y=e.getY()-360;
                        Curve.originDots.get(k).y=e.getY()-360;
                    }
                    else if (Curve.Dots.get(k).y>0 && Math.abs(Curve.Dots.get(k).y)>=360){
                        Curve.Dots.get(k).y=325;
                        Curve.originDots.get(k).y=325;
                    }
                    else if (Curve.Dots.get(k).y<0 && Math.abs(Curve.Dots.get(k).y)>=360){
                        Curve.Dots.get(k).y=-325;
                        Curve.originDots.get(k).y=-325;
                    }
                }while(Math.abs(Curve.Dots.get(k).x)>=360 || Math.abs(Curve.Dots.get(k).y)>=360);

                Paint.repaint();

            }
        }
        @Override
        public void mouseMoved(MouseEvent e)
        {
        }


    }
    public static void main(String[] args) {
        Window dialog = new Window();
        dialog.pack();
        dialog.setVisible(true);

    }

}
