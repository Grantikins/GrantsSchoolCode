import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import java.io.*; //IO Library for testing System.out messages

public class TriangleTester{

    private Shape t1, t2, t3, t4;
    private Point2D p1, p2, p3;

    /**
     * This method sets up the points and the shapes that are needed for the tests to begin.
     */
    @Before
    public void setUp(){
        p1 = new Point2D(2, 4);
        p2 = new Point2D(0, 4);
        p3 = new Point2D(0, 6);

        t1 = new Triangle(new Point2D(5, 8), new Point2D(7, 4), new Point2D(5, 4));
        t2 = new Triangle(new Point2D(4.25, 1), new Point2D(-2.08, 1), new Point2D(3.1, 6.6));
        t3 = new Triangle(new Point2D(5.5, -3.3), new Point2D(0, 1.91), new Point2D(4, 1.91));

        t4 = new Triangle(p1, p2, p3);
    }

    /**
     * This method tests that the getArea method for the triangle works as intended with multiple cases.
     */
    @Test
    public void testGetArea(){
        double tolerance = 0.001;

        assertEquals(4, t1.getArea(), tolerance);
        assertEquals(17.724, t2.getArea(), tolerance);
        assertEquals(10.42, t3.getArea(), tolerance);
    }

    /**
     * This method tests that the getPerimeter method for the triangle works as intended with multiple cases.
     */
    @Test
    public void testGetPerimeter(){
        double tolerance = 0.001;

        assertEquals(10.472, t1.getPerimeter(), tolerance);
        assertEquals(19.675, t2.getPerimeter(), tolerance);
        assertEquals(16.998, t3.getPerimeter(), tolerance);
    }

    /**
     * This method tests that the findBase method that is used in both rectangle and triangle classes works as intended.
     */
    @Test 
    public void testFindBase(){
        double tolerance = 0.001;

        assertEquals(2, t1.findBase(), tolerance);
        assertEquals(6.33, t2.findBase(), tolerance);
        assertEquals(4, t3.findBase(), tolerance);
    }

    /**
     * This method tests that the getVertex method works as intended using a triangle with set points.
     */
    @Test 
    public void testGetVertex(){
        assertEquals(p1, t4.getVertex(0));
        assertEquals(p2, t4.getVertex(1));
        assertEquals(p3, t4.getVertex(2));
    }

}