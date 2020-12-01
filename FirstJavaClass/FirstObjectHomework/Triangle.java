/**
 * @author Grant Randell
 * A subclass of Shape that calculates geometric properties of Triangles.
 */
public class Triangle extends Shape{

    private double base, height;

    /**
     * The Triangle constructor that takes in three points, finds the base and height.
     * @param point1
     * @param point2
     * @param point3
     */
    public Triangle(Point2D point1, Point2D point2, Point2D point3){
        super(point1, point2, point3);
        this.base = findBase();
        setTriangleHeight();
    }

    /**
     * A method that finds the height of a triangle. It is called in the constructor.
     */
    private void setTriangleHeight(){
        for(int i = 0; i < points.size(); i++){
            if(basePoint != points.get(i)){
                if(basePoint.getY() != points.get(i).getY()){
                    height = Math.abs(basePoint.getY() - points.get(i).getY());
                } 
            }
        }
    }

    /**
     * A method that returns the Triangle perimeter based on the distance between each of the points.
     * @return Triangle perimeter
     */
    public double getPerimeter(){
        return point1.distance(point2) + point2.distance(point3) + point3.distance(point1);
    }

    /**
     * A method that returns the Triangle area based on the calculated base and height.
     * @return Triangle Area
     */
    public double getArea(){
        return .5 * base * height;
    }

}