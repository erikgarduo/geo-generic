package ignity.geo.generic.controller;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import ignity.geo.generic.Model.GenericPoint;
import ignity.geo.generic.Service.ServiceGenericPoints;
import ignity.geo.generic.Util.CORSFilter;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@WebMvcTest(GenericPointsController.class)
public class GenericPointsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServiceGenericPoints serviceGenericPoints;

    @BeforeAll
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(GenericPointsController.class)
                .addFilters(new CORSFilter())
                .build();
    }

    @Test
    public void getOneGenericPoint() throws Exception {
        final String urlResourceGenericPoint = "/generic-point";
        final long idGenericPoint = 1;

        final String jsonResponse = "{\n" +
                "    \"name\": \"Name\",\n" +
                "    \"active\": true,\n" +
                "    \"lat\": -12.3133223,\n" +
                "    \"lon\": 96.24344\n" +
                "}";

        RequestBuilder request = MockMvcRequestBuilders
                .get(urlResourceGenericPoint)
                .queryParam("idGenericPoint", String.valueOf(idGenericPoint))
                .accept(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonResponse))
                .andReturn();

        JSONAssert.assertEquals(result.getResponse().getContentAsString(), jsonResponse, true);
    }

    @Test
    public void getAllGenericPoints() throws Exception {
        final String urlResourceGenericPoint = "/all-generic-point";

        final String jsonResponse = "[\n" +
                "    {\n" +
                "        \"name\": \"Name\",\n" +
                "        \"active\": true,\n" +
                "        \"lat\": -12.3133223,\n" +
                "        \"lon\": 96.24344\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Name2\",\n" +
                "        \"active\": true,\n" +
                "        \"lat\": -12.3133223,\n" +
                "        \"lon\": 96.24344\n" +
                "    }\n" +
                "]";

        Mockito.when(serviceGenericPoints.retrieveAllGenericPoints()).thenReturn(new ArrayList<>(Arrays.asList(
                new GenericPoint("Name", Boolean.TRUE, -12.3133223, 96.24344),
                new GenericPoint("Name2", Boolean.TRUE, -12.3133223, 96.24344))));

        RequestBuilder request = MockMvcRequestBuilders
                .get(urlResourceGenericPoint)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonResponse))
                .andReturn();

        JSONAssert.assertEquals(result.getResponse().getContentAsString(), jsonResponse, true);
    }

    @Test
    public void postGenericPoints() throws Exception {
        final String urlResourceGenericPoint = "/generic-point";

        final String content = "{name: Name,active:true,lat: -12.3133223,lon: 96.24344}";

        GenericPoint genericPoint = new GenericPoint("Name", Boolean.TRUE, -12.3133223, 96.24344);

        Mockito.when(serviceGenericPoints.createGenericPoint(any(GenericPoint.class))).
                thenReturn(new ResponseEntity(HttpStatus.CREATED));

        RequestBuilder request = MockMvcRequestBuilders
                .post(urlResourceGenericPoint)
                .content(asJsonString(genericPoint))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
    }

    @Test
    public void updateGenericPoints() throws Exception {
        final long idGenericPoint = 1;

        final String urlResourceGenericPoint = String.format("/generic-point/%d", idGenericPoint);

        final String content = "{name: Name,active:true,lat: -12.3133223,lon: 96.24344}";

        GenericPoint genericPoint = new GenericPoint("Name", Boolean.FALSE, -12.3133223, 96.24344);

        Mockito.when(serviceGenericPoints.updateGenericPoint(any(GenericPoint.class))).
                thenReturn(new ResponseEntity(HttpStatus.NO_CONTENT));

        RequestBuilder request = MockMvcRequestBuilders
                .put(urlResourceGenericPoint)
                .content(asJsonString(genericPoint))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andReturn();
    }

    @Test
    public void deleteGenericPoints() throws Exception {
        final long idGenericPoint = 1;

        final String urlResourceGenericPoint = String.format("/generic-point/%d", idGenericPoint);

        Mockito.when(serviceGenericPoints.deleteGenericPoint(any(Long.class))).
                thenReturn(new ResponseEntity(HttpStatus.NO_CONTENT));

        RequestBuilder request = MockMvcRequestBuilders
                .delete(urlResourceGenericPoint)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andReturn();
    }

    /*
    @Test
    public void corsHeaders() throws Exception {
        final String urlResourceGenericPoint = "/generic-point";

        RequestBuilder request = MockMvcRequestBuilders
                .options(urlResourceGenericPoint)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(header().string("Access-Control-Allow-Origin", "*"))
                .andExpect(header().string("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE"))
                .andExpect(header().string("Access-Control-Allow-Headers", "*"))
                .andExpect(header().string("Access-Control-Max-Age", "3600"));
    }*/

    /*
     * converts a Java object into JSON representation
     */
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
