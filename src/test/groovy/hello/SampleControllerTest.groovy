
package hello

import org.junit.Test

class SampleControllerTest {

    @Test
    void testHello() {
        assert "Hello World!" == new SampleController().home()
    }
}

