package test.java.com.app.controllers;

import com.app.entities.CitaEntity;
import com.app.services.CitaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CitaController.class)
public class CitaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CitaService citaService;

    @InjectMocks
    private CitaController citaController;

    @Test
    public void testGetAllCitas() throws Exception {
    
        CitaEntity cita1 = new CitaEntity(1L, "Cardiología", new Date());
        CitaEntity cita2 = new CitaEntity(2L, "Dermatología", new Date());
        List<CitaEntity> citas = Arrays.asList(cita1, cita2);

        when(citaService.getAllCitas()).thenReturn(citas);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/citas"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(citas.size()));
    }

}
