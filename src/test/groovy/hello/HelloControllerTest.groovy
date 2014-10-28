package hello

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.ui.Model

import static org.mockito.Mockito.verify

class HelloControllerTest {

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
    void testGreet() {

        // Setup
        String name = "Jambert"

        // Run
        String response = new HelloController().greet(name, model)

        // Verify
        verify(model).addAttribute(keyCaptor.capture(), valueCaptor.capture())
        assert "greet" == response
        assert "name" == keyCaptor.value
        assert name == valueCaptor.value
    }
}

