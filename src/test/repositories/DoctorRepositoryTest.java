package test.java.com.app.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.entities.DoctorEntity;
import com.app.repositories.DoctorRepository;

@DataJpaTest
public class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void testFindDoctorsByEspecialidad() {
        DoctorEntity doctor1 = new DoctorEntity("John", "Doe", "Cardiologia", "Room 101", "john.doe@example.com");
        DoctorEntity doctor2 = new DoctorEntity("Jane", "Smith", "Dermatologia", "Room 202", "jane.smith@example.com");
        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);

        List<DoctorEntity> cardiologyDoctors = doctorRepository.findDoctorsByEspecialidad("Cardiology");

        assertEquals(1, cardiologyDoctors.size());
        assertEquals("John", cardiologyDoctors.get(0).getNombre());
    }

}
