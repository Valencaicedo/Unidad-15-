package test.java.com.app.controllers;

import com.app.entities.PacienteEntity;
import com.app.services.PacienteService;
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
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PacienteService pacienteService;

    @InjectMocks
    private PacienteController pacienteController;

    @Test
    public void testGetAllPacientes() throws Exception {
        PacienteEntity paciente1 = new PacienteEntity("Alice", "123456789", "Smith", 30, "123-456-7890");
        PacienteEntity paciente2 = new PacienteEntity("Bob", "987654321", "Johnson", 40, "987-654-3210");
        List<PacienteEntity> pacientes = Arrays.asList(paciente1, paciente2);

        when(pacienteService.getAllPacientes()).thenReturn(pacientes);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/pacientes"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(pacientes.size()));
    }

}
