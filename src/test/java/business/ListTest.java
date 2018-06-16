package business;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




public class ListTest {

    @Mock
    private List listMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void letsMockListSize() {
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    // Return multiple values
    @Test
    public void letsMockListSize_returnMultipleValues() {
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void letsMockListGet() {
        // Argument Matchers
        when(listMock.get(anyInt())).thenReturn("mendonca");

        assertEquals("mendonca", listMock.get(0));
        // if there is nothing then it will return null
        assertEquals("mendonca",listMock.get(100000));
    }

    @Test
    public void letsMockListGet_usingBDD() {
        Random random = new Random();
        // Given
        List<String> listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("mendonca");

        // When
        String anyElement = listMock.get(random.nextInt());

        // Then
        assertThat(anyElement, is("mendonca"));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_throwAnException() {
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("X"));
        listMock.get(8393);
    }

    // Given - setup
    // When - actual method call
    // Then - asserts
}
