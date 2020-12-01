import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import java.io.*; //IO Library for testing System.out messages

public class RectangleTester{

    private Shape r1, r2, r3;
    private Point2D p1, p2, p3, p4;

    /**
     * This method sets up the points and the rectangles needed to run the tests.
     */
    @Before
    public void setUp(){
        p1 = new Point2D(2, 4);
        p2 = new Point2D(0, 4);
        p3 = new Point2D(0, 6);
        p4 = new Point2D(2, 6);

        r1 = new Rectangle(p1, p2, p3, p4);
        r2 = new Rectangle(new Point2D(7.815, 11.2), new Point2D(7.815, 3.61), new Point2D(4.5, 3.61), new Point2D(4.5, 11.2));
        r3 = new Rectangle(new Point2D(-1.75, -6.77), new Point2D(-1.75, 5.55), new Point2D(1.01, 5.55), new Point2D(1.01, -6.77));
    }

    /**
     * This method tests that the getArea method for the rectangle works as intended with multiple cases.
     */
    @Test
    public void testGetArea(){
        double tolerance = 0.001;

        assertEquals(4, r1.getArea(), tolerance);
        assertEquals(25.161, r2.getArea(), tolerance);
        assertEquals(34.003, r3.getArea(), tolerance);
    }

    /**
     * This method tests that the getPerimeter method for the rectangle works as intended with multiple cases.
     */
    @Test
    public void testGetPerimeter(){
        double tolerance = 0.001;

        assertEquals(8, r1.getPerimeter(), tolerance);
        assertEquals(21.81, r2.getPerimeter(), tolerance);
        assertEquals(30.16, r3.getPerimeter(), tolerance);
    }

    /**
     * This method tests that the findBase method that is used in both rectangle and triangle classes works as intended.
     */
    @Test 
    public void testFindBase(){
        double tolerance = 0.001;

        assertEquals(2, r1.findBase(), tolerance);
        assertEquals(3.315, r2.findBase(), tolerance);
        assertEquals(2.76, r3.findBase(), tolerance);
    }

    /**
     * This method tests that the getVertex method works as intended using a rectangle with set points.
     */
    @Test 
    public void testGetVertex(){
        assertEquals(p1, r1.getVertex(0));
        assertEquals(p2, r1.getVertex(1));
        assertEquals(p3, r1.getVertex(2));
        assertEquals(p4, r1.getVertex(3));
    }

}