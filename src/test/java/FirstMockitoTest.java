import org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FirstMockitoTest {

    @Test
    public void test() {
        List mockedList = mock(List.class);

        // using the mock object
        mockedList.add("Dogs");
        mockedList.add("Cats");

        // verification
        verify(mockedList).add("Dogs");
        verify(mockedList).add("Cats");
    }
}
