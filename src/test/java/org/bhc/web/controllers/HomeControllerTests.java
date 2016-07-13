package org.bhc.web.controllers;

import org.bhc.WebsiteApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.view.ThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebsiteApplication.class)
@WebAppConfiguration
public class HomeControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void indexPageLoad() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/index"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void membershipPageLoad() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/membership"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void infoAndRulesPageLoad() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/infoAndRules"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void calendarPageLoad() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calendar"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void beginnersPageLoad() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/beginners"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
