package hello

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate

/**
 * Created by outcastgeek on 10/28/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:9000")
class SampleControllerIntegrationTest {

    XmlParser xmlParser = null

    @Before
    void before() {
        xmlParser = new XmlParser()
    }

    @Test
    void testHello() {

        // Setup
        RestTemplate restTemplate = new TestRestTemplate()

        // Run
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9000/", String.class)

        // Verify
        def html = xmlParser.parseText(response.getBody())
        assert "Hello" ==  html.head.title.text()
        assert "Hello World! !!!" ==  html.body.h1.text()
    }

}
