package test.java.com.app.controllers;

import com.app.entities.DoctorEntity;
import com.app.services.DoctorService;
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
@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorController doctorController;

    @Test
    public void testGetAllDoctors() throws Exception {
        DoctorEntity doctor1 = new DoctorEntity("John", "Doe", "Cardiologia", "Room 101", "john.doe@example.com");
        DoctorEntity doctor2 = new DoctorEntity("Jane", "Smith", "Dermatologia", "Room 202", "jane.smith@example.com");
        List<DoctorEntity> doctors = Arrays.asList(doctor1, doctor2);

        when(doctorService.getAllDoctors()).thenReturn(doctors);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/doctors"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(doctors.size()));
    }


}
