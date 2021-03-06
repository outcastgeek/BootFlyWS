package hello

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.verify
import org.springframework.ui.Model

class SampleControllerTest {

    @Mock
    Model model

    @Captor
    ArgumentCaptor<String> keyCaptor

    @Captor
    ArgumentCaptor<String> valueCaptor

    @Before
    void before() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    void testHello() {

        // Run
        String response = new SampleController().home(model)

        // Verify
        verify(model).addAttribute(keyCaptor.capture(), valueCaptor.capture())
        assert "hello" == response
        assert "greeting" == keyCaptor.value
        assert "Hello World!" == valueCaptor.value
    }
}

