import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void test() {

        List arrayListSpy = spy(ArrayList.class);
        // spy makes a real instance of the class
        // mocks return default values
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        assertEquals(1, arrayListSpy.size());

        verify(arrayListSpy).add("Dummy");
        verify(arrayListSpy, never()).clear();

    }
}
