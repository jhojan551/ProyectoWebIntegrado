package avanceWI.controller;

import avanceWI.model.Avance;
import avanceWI.service.AvanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avances")
public class AvanceController {
    private final AvanceService avanceService;

    public AvanceController(AvanceService avanceService) {
        this.avanceService = avanceService;
    }

    // Obtener todos los avances (GET)
    @GetMapping
    public List<Avance> getAllAvances() {
        return avanceService.getAllAvances();
    }

    // Obtener un avance por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Avance> getAvanceById(@PathVariable Long id) {
        Optional<Avance> avance = avanceService.getAvanceById(id);
        return avance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo avance (POST)
    @PostMapping
    public Avance addAvance(@RequestBody Avance avance) {
        return avanceService.addAvance(avance);
    }

    // Actualizar un avance (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Avance> updateAvance(@PathVariable Long id, @RequestBody Avance newAvance) {
        Optional<Avance> updatedAvance = avanceService.updateAvance(id, newAvance);
        return updatedAvance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un avance (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvance(@PathVariable Long id) {
        boolean deleted = avanceService.deleteAvance(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}