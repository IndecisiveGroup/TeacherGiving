package org.giving.teacher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers=Greeting.class)
public class GreetingTest{

	@Autowired
	WebClient client;
	
    @Test
    public void testDefault() throws Exception {
    	HtmlPage page = client.getPage("http://localhost:8080/greeting");
    	assertEquals("Hello, World!", page.getBody().getTextContent().trim());
    }
    
    @Test
    public void testName() throws Exception {
    	HtmlPage page = client.getPage("http://localhost:8080/greeting?name=Kyle");
    	assertEquals("Hello, Kyle!", page.getBody().getTextContent().trim());
    }

}
