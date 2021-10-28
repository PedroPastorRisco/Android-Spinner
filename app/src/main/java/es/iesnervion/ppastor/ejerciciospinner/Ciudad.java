package es.iesnervion.ppastor.ejerciciospinner;

public class Ciudad {
    private String nombre;
    private int idImagen;

    public Ciudad(String nombre,int idImagen){
        this.nombre=nombre;
        this.idImagen=idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
