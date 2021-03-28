package GraphiLab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;



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
    private final Font myFont;
    protected Cover BezierCover;
    private final Axis X;
    private final Axis Y;
    private final Axis Z;
    private final Axis newAxis;
    private Graphics2D drawing2D;

    public Window() {
        setContentPane(contentPane);
        this.setMinimumSize(new Dimension(1280, 720));
        this.setMaximumSize(new Dimension(1280, 720));
        this.setResizable(false);
        this.setTitle("КГ №3 Вариант 3");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        newAxis = new Axis(new Dot(0, 0, 0), new Dot(1, 0, 0));
        myFont=new Font ("Courier New", Font.BOLD, 17);
        rotationAngle.setToolTipText(rotationAngle.getValue() + " °");
        A.setFont(new Font ("Courier New", Font.BOLD, 8));
        B.setFont(new Font ("Courier New", Font.BOLD, 8));
        rot.setFont(new Font ("Courier New", Font.BOLD, 8));
        BezierCover=new Cover();
        BezierCover.rotation();
        BezierCover.projection();


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
                drawing2D = (Graphics2D) drawing;
                drawing2D.setColor(Color.BLACK);
                drawing2D.fillRect(0, 0, 720, 720);
                drawing2D.translate(360, 360);


                Path2D axisPath = new Path2D.Double();
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
                drawing2D.setColor(Color.DARK_GRAY);
                drawing2D.draw(axisPath);


                Path2D newAxisPath = new Path2D.Double();
                newAxisPath.moveTo(newAxis.A.x, newAxis.A.y);
                newAxisPath.lineTo(newAxis.B.x, newAxis.B.y);
                newAxisPath.closePath();

                drawing2D.setColor(Color.CYAN);
                drawing2D.draw(newAxisPath);


                Path2D path = new Path2D.Double();
                GradientPaint grad = new GradientPaint(-240, -240, Color.CYAN, 140, 140, Color.MAGENTA, true);

                drawing2D.setPaint(grad);
                drawing2D.draw(BezierCover.starting());
                drawing2D.setColor(Color.ORANGE);
                for (int i = 0; i < BezierCover.Dots.length; i++) {
                    for (int j = 0; j < BezierCover.Dots[0].length; j++) {
                        drawing2D.drawOval((int) BezierCover.Dots[i][j].x, (int) BezierCover.Dots[i][j].y, 5, 5);
                    }
                }
                drawing2D.setColor(Color.ORANGE);
                for (int i = 0; i < BezierCover.Dots.length - 1; i++) {
                    for (int j = 0; j < BezierCover.Dots[0].length - 1; j++) {
                        path.moveTo(BezierCover.Dots[i][j].x, BezierCover.Dots[i][j].y);
                        path.lineTo(BezierCover.Dots[i][j + 1].x, BezierCover.Dots[i][j + 1].y);
                        path.moveTo(BezierCover.Dots[i][j].x, BezierCover.Dots[i][j].y);
                        path.lineTo(BezierCover.Dots[i + 1][j].x, BezierCover.Dots[i + 1][j].y);
                        path.moveTo(BezierCover.Dots[i][3].x, BezierCover.Dots[i][3].y);
                        path.lineTo(BezierCover.Dots[i + 1][3].x, BezierCover.Dots[i + 1][3].y);
                        path.moveTo(BezierCover.Dots[5][j].x, BezierCover.Dots[i][3].y);
                    }
                }
                for (int i = 0; i < BezierCover.Dots[0].length - 1; i++) {
                    path.moveTo(BezierCover.Dots[5][i].x, BezierCover.Dots[5][i].y);
                    path.lineTo(BezierCover.Dots[5][i + 1].x, BezierCover.Dots[5][i + 1].y);
                }
                path.closePath();
                drawing2D.setFont(myFont);
                drawing2D.drawString(rotationAngle.getValue() + " °", 290, 290);
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
            rotationAngle.setToolTipText(rotationAngle.getValue() + " °");
            if (newAxis.originA.y == 0 && newAxis.originA.z == 0 && newAxis.originB.y == 0 && newAxis.originB.z == 0)
                BezierCover.rotationX(rotationAngle.getValue());
            else if (newAxis.originA.x == 0 && newAxis.originA.z == 0 && newAxis.originB.x == 0 && newAxis.originB.z == 0)
                BezierCover.rotationY(rotationAngle.getValue());
            else if (newAxis.originA.y == 0 && newAxis.originA.x == 0 && newAxis.originB.y == 0 && newAxis.originB.x == 0)
                BezierCover.rotationZ(rotationAngle.getValue());
            else BezierCover.rotateShapeByAxis(newAxis.originA, newAxis.originB, rotationAngle.getValue());
            BezierCover.rotation();
            BezierCover.projection();
            Paint.repaint();
        });
        Paint.addMouseMotionListener(new Mouse());

    }

    private class Mouse implements MouseMotionListener {

        int rad;
        int k=-1;
        int m=-1;
        boolean beingDragged=false;

        @Override
        public void mouseDragged(MouseEvent e)
        {
            if (beingDragged)
            {
                beingDragged=false;

            }

            for (int i = 0; i<BezierCover.Dots.length && !beingDragged ; i++)
            {
                for (int j = 0; j<BezierCover.Dots[0].length && !beingDragged;j++)
                {
                    rad=(int)Math.sqrt((Math.pow(BezierCover.Dots[i][j].x-(double)(e.getX()-360),2)+Math.pow((BezierCover.Dots[i][j].y-(double)(e.getY()-360)),2)));
                    if(rad<=10)
                    {
                        beingDragged=true;
                        k=i;
                        m=j;
                    }
                }

            }
            if (beingDragged)
            {

                do
                {
                    if(Math.abs(BezierCover.Dots[k][m].x)<360)
                    {
                        BezierCover.Dots[k][m].x = e.getX() - 360;
                        BezierCover.originDots[k][m].x=e.getX()-360;
                    }
                    else if (BezierCover.Dots[k][m].x>0 && Math.abs(BezierCover.Dots[k][m].x)>=360){
                        BezierCover.Dots[k][m].x=325;
                        BezierCover.originDots[k][m].x=325;
                    }
                    else if (BezierCover.Dots[k][m].x<0 && Math.abs(BezierCover.Dots[k][m].x)>=360){
                        BezierCover.Dots[k][m].x = -325;
                        BezierCover.originDots[k][m].x=-325;
                    }
                    if(Math.abs(BezierCover.Dots[k][m].y)<360) {
                        BezierCover.Dots[k][m].y=e.getY()-360;
                        BezierCover.originDots[k][m].y=e.getY()-360;
                    }
                    else if (BezierCover.Dots[k][m].y>0 && Math.abs(BezierCover.Dots[k][m].y)>=360){
                        BezierCover.Dots[k][m].y=325;
                        BezierCover.originDots[k][m].y=325;
                    }
                    else if (BezierCover.Dots[k][m].y<0 && Math.abs(BezierCover.Dots[k][m].y)>=360){
                        BezierCover.Dots[k][m].y=-325;
                        BezierCover.originDots[k][m].y=-325;
                    }
                }while(Math.abs(BezierCover.Dots[k][m].x)>=360 || Math.abs(BezierCover.Dots[k][m].y)>=360);

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
