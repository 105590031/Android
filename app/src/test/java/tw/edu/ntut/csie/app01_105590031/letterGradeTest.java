package tw.edu.ntut.csie.app01_105590031;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by NTUTCSIE on 2018/4/25.
 */

public class letterGradeTest {
    private   MainActivity ms;

    @Before
    public void setUp(){
        ms = new MainActivity();
    }

    @After
    public void tearDown(){
        ms = null;
    }

    @Test
    public void testGetSuggestion() {
        assertEquals("grade = X", 101);
        assertEquals("grade = A", 90);
        assertEquals("grade = B", 80);
        assertEquals("grade = C", 70);
        assertEquals("grade = D", 60);
        assertEquals("grade = F", 59);
        assertEquals("grade = X", -1);
    }
}
