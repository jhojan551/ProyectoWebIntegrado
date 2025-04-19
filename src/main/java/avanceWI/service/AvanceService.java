package avanceWI.service;

import avanceWI.model.Avance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AvanceService {
    private final List<Avance> avances = new ArrayList<>();

    // Obtener todos los avances
    public List<Avance> getAllAvances() {
        return avances;
    }

    // Obtener un avance por su ID
    public Optional<Avance> getAvanceById(Long id) {
        return avances.stream().filter(avance -> avance.getId().equals(id)).findFirst();
    }

    // Agregar un nuevo avance
    public Avance addAvance(Avance avance) {
        // asignar un ID único al nuevo avance
        Long nuevoId = (long) (avances.size() + 1);
        avance.setId(nuevoId);
        avances.add(avance);
        return avance;
    }

    // Actualizar un avance
    public Optional<Avance> updateAvance(Long id, Avance newAvance) {
        return getAvanceById(id).map(avance -> {
            avance.setNombre(newAvance.getNombre());
            avance.setEstado(newAvance.getEstado());
            return avance;
        });
    }

    // Eliminar un avance
    public boolean deleteAvance(Long id) {
        return avances.removeIf(avance -> avance.getId().equals(id));
    }
}