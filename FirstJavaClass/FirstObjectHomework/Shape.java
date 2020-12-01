import java.util.ArrayList;
/**
 * @author Grant Randell
 * A superclass that is used to set the foundation for what a shape is.
 */
public abstract class Shape{

    protected ArrayList<Point2D> points = new ArrayList();
    protected Point2D point1, point2, point3, point4, centerPoint;
    protected Point2D basePoint;
    protected double radius;

    /**
     * Takes in four points and places them inside of a points arrayList.
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     */
    public Shape(Point2D point1, Point2D point2, Point2D point3, Point2D point4){
        points.add(point1);
        this.point1 = point1;
        points.add(point2);
        this.point2 = point2;
        points.add(point3);
        this.point3 = point3;
        points.add(point4);
        this.point4 = point4;
    }

    /**
     * Takes in three points and places them inside of a points arrayList.
     * @param point1
     * @param point2
     * @param point3
     */
    public Shape(Point2D point1, Point2D point2, Point2D point3){
        points.add(point1);
        this.point1 = point1;
        points.add(point2);
        this.point2 = point2;
        points.add(point3);
        this.point3 = point3;
    }

    public Shape(Point2D centerPoint, double radius){
        this.centerPoint = centerPoint;
        points.add(centerPoint);
        this.radius = radius;
    }

    /**
     * Finds a line parallel to the x-axis and returns it's length. It also stores one of the points connected to the base for later use.
     * It is called in the Rectangle and Triangle constructors. 
     * @return the length of the determined base
     */
    public double findBase(){
        double base;
        for(int i = 0; i < points.size(); i++){
            if(Math.abs(points.get(i).getY() - points.get(i+1).getY()) < .001){
                base = points.get(i).distance(points.get(i+1));
                basePoint = points.get(i);
                return base;
            }
        }
        return 0;
    }

    /**
     * Finds the Area of the shape using the calculated base and height.
     * @return the area
     */
    public abstract double getArea();
    
    /**
     * Finds the Perimeter of the shape using the calculated base and height.
     * @return the perimeter
     */
    public abstract double getPerimeter();

    /**
     * Takes in an index and returns whatever is inside of the points arraylist at that index.
     * @param index the desired index in the points array
     * @return a Point2D object at the indicated index
     */
    public Point2D getVertex(int index){
        return this.points.get(index);
    }

}