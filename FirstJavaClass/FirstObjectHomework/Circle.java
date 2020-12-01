/**
 * @author Grant Randell
 */
public class Circle extends Shape{

    public Circle(Point2D centerPoint, double radius){
        super(centerPoint, radius);
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }

}