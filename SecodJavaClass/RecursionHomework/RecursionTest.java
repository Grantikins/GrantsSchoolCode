import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;


public class RecursionTest{

    String name, name2, word, word2, normal, normal2, equal, equal2;
    String[] sArray = {"Grant", "Greg", "blah", "meh"};
    String[] strArray = {"Grant", "field", "equal"};
    String[] eArray = {"blah",  "equal", "equal"};

    @Before
    public void setup(){
        name = "Grant";
        name2 = "Greg";
        word = "field";
        word2 = "fields";
        normal = "blah";
        normal2 = "meh";
        equal = "equal";
        equal2 = "equal";
    }

    @Test 
    public void testCompare(){
        assertEquals(-4, Recursion.compare(name, name2));
        assertEquals(-1, Recursion.compare(word, word2));
        assertEquals(11, Recursion.compare(normal2, normal));
        assertEquals(0, Recursion.compare(equal, equal2));
    }

    @Test 
    public void testFindMinimum(){
        assertEquals("blah", Recursion.findMinimum(sArray, 4));
        assertEquals("equal", Recursion.findMinimum(strArray, 3));
        assertEquals("blah", Recursion.findMinimum(eArray, 3));
    }

}