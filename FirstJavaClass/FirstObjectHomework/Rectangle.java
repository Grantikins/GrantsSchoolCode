/**
 * @author Grant Randell
 * A subclass of Shape that calculates geometric properties of Rectangles.
 */
public class Rectangle extends Shape{

    private double base, height;

    /**
     * A constructor for a Rectangle that takes in four points, finds a base and a height.
     * @param point1 The first point that connects to the second and fourth.
     * @param point2 The second point that connects to the first and third.
     * @param point3 The third point that connects to the second and the fourth.
     * @param point4 The fourth point that connects to the first and the third.
     */
    public Rectangle(Point2D point1, Point2D point2, Point2D point3, Point2D point4){
        super(point1, point2, point3, point4);
        this.base = findBase();
        setRectangleHeight();
    }

    /**
     * A method that calculates and sets the rectangle height. It is called in the constructor.
     */
    private void setRectangleHeight(){
        if(Math.abs(point1.distance(point2) - base) < .001){
            height = point2.distance(point3);
        }
        else{
            height = point1.distance(point2);
        }
    }

    /**
     * A getter method that returns the rectangle area using the calculated base and height.
     * @return a double value calculated from the base and the height
     */
    public double getArea(){
        return base * height;
    }

    /**
     * A getter method that returns the rectanlge perimeter using the calculated base and height.
     * @return a double value calculated from the base and the height
     */
    public double getPerimeter(){
        return base * 2 + height * 2;
    }

}