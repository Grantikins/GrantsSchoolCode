import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import java.io.*;

// This is a Class to test our LinkedList and Iterator Classes with JUnit
public class Tester{

    private Dog teenie = new Dog("Teenie", 1, 2);
    private Dog chubbs = new Dog("Chubbs", 25, 5);
    private Dog buddy = new Dog("Buddy", 30, 9);
    private Dog doc = new Dog("Doc", 35, 8);
    private Dog ghost = new Dog("Ghost", 100, 12);
    private Dog NotHere = new Dog("Not Here", 0, 0);

    LinkedList<Dog> dogClub = new LinkedList<Dog>();
    Iterator<Dog> it;

    @Before
    public void setUp(){
        dogClub.add(teenie);
        dogClub.add(chubbs);
        dogClub.add(buddy);
        dogClub.add(doc);
        dogClub.add(ghost, 2);
        it = dogClub.getIterator();
    }

    @Test
    public void testBasic(){
        assertEquals(5, dogClub.size());
        assertEquals(teenie, dogClub.get(0));
        assertEquals(chubbs, dogClub.get(1));
        assertEquals(ghost, dogClub.get(2));
        assertEquals(doc, dogClub.get(4));
    }

    @Test
    public void testContain(){
        assertTrue(dogClub.contains(chubbs));
        assertTrue(dogClub.contains(doc));
        assertFalse(dogClub.contains(NotHere));
    }

    @Test
    public void testIndexOf(){
        assertEquals(0, dogClub.indexOf(teenie));
        assertEquals(2, dogClub.indexOf(ghost));
        assertEquals(-1, dogClub.indexOf(NotHere));
    }

    @Test
    public void testIteratorAt(){
        assertEquals(null, dogClub.iteratorAt(NotHere));
        //assertEquals(dogClub.getIterator(), dogClub.iteratorAt(teenie));
    }

    @Test 
    public void testIterator(){
        assertTrue(it.hasNext());
        assertTrue(it.hasPrior());
        assertEquals(teenie, it.next());
        it.setToEnd();
        assertTrue(it.hasPrior());
        assertTrue(it.hasNext());
    }
}