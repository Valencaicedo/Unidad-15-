package test.java.com.app.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.entities.PacienteEntity;
import com.app.repositories.PacienteRepository;

@DataJpaTest
public class PacienteRepositoryTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void testFindPacientesByEdadGreaterThan() {

        PacienteEntity paciente1 = new PacienteEntity("Alice", "123456789", "Smith", 30, "123-456-7890");
        PacienteEntity paciente2 = new PacienteEntity("Bob", "987654321", "Johnson", 40, "987-654-3210");
        pacienteRepository.save(paciente1);
        pacienteRepository.save(paciente2);


        List<PacienteEntity> pacientesMayoresDe35 = pacienteRepository.findPacientesByEdadGreaterThan(35);


        assertEquals(1, pacientesMayoresDe35.size());
        assertEquals("Bob", pacientesMayoresDe35.get(0).getNombre());
    }


}
