package test.java.com.app.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.entities.CitaEntity;
import com.app.repositories.CitaRepository;

@DataJpaTest
public class CitaRepositoryTest {

    @Autowired
    private CitaRepository citaRepository;

    @Test
    public void testFindCitasByEspecialidad() {
        CitaEntity cita1 = new CitaEntity("Cardiología");
        CitaEntity cita2 = new CitaEntity("Dermatología");
        citaRepository.save(cita1);
        citaRepository.save(cita2);

        List<CitaEntity> citasCardiologia = citaRepository.findCitasByEspecialidad("Cardiología");

        assertEquals(1, citasCardiologia.size());
        assertEquals("Cardiología", citasCardiologia.get(0).getEspecialidad());
    }

}
