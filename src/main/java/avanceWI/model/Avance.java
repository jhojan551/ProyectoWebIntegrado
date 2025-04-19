package avanceWI.model;

public class Avance {
    private Long id;
    private String nombre;
    private String estado;

    // Constructor sin argumentos (REQUIRED para la deserialización)
    public Avance() {
    }

    // Constructor opcional con argumentos
    public Avance(Long id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}