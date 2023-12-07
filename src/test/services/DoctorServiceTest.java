package test.java.com.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.entities.DoctorEntity;
import com.app.repositories.DoctorRepository;
import com.app.services.DoctorService;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void testGetAllDoctors() {
        DoctorEntity doctor1 = new DoctorEntity("John", "Doe", "Cardiologia", "Room 101", "john.doe@example.com");
        DoctorEntity doctor2 = new DoctorEntity("Jane", "Smith", "Dermatologia", "Room 202", "jane.smith@example.com");
        List<DoctorEntity> doctors = Arrays.asList(doctor1, doctor2);

        when(doctorRepository.findAll()).thenReturn(doctors);

        List<DoctorEntity> result = doctorService.getAllDoctors();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getNombre());
        assertEquals("Dermatologia", result.get(1).getEspecialidad());
    }
