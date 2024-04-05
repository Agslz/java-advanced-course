package models;

import java.util.Objects;

public class Persona {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    //Eliminamos el constructor vacio para utilizar el que ya posee parametros y ademas eliminamos los setters

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && Objects.equals(email, persona.email) && Objects.equals(telefono, persona.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, email, telefono);
    }

    @Override
    public String toString() {
        return "models.Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


    public static final class Builder {
        private String nombre;
        private String apellido;
        private String email;
        private String telefono;

        private Builder() {
        }

        public static Builder aPersona() {
            return new Builder();
        }

        public Builder withNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder withApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Persona build() {
            return new Persona(nombre, apellido, email, telefono);
        }
    }
}
