import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import java.io.*; //IO Library for testing System.out messages

public class CircleTester{

    private Shape c1, c2;
    private double rad1, rad2;
    private Point2D p1, p2;

    /**
     * This method sets up the points and the shapes that are needed for the tests to begin.
     */
    @Before
    public void setUp(){
        p1 = new Point2D(2, 4);
        p2 = new Point2D(0, 6);
        rad1 = 9;
        rad2 = 25;

        c1 = new Circle(p1, rad1);
        c2 = new Circle(p2, rad2);
    }

    @Test
    public void testCircleGetArea(){
        assertEquals(254.47, c1.getArea(), .001);
        assertEquals(1963.495, c2.getArea(), .001);
    }

    @Test
    public void testCirclePerimeter(){
        assertEquals(56.548, c1.getPerimeter(), .001);
        assertEquals(157.08, c2.getPerimeter(), .001);
    }

}