import models.Persona;

import static models.Persona.Builder.aPersona;

public class Main {
    public static void main(String[] args) {

        Persona p = aPersona()
                .withApellido("Agustin")
                .withApellido("Schulze")
                .withTelefono("2439294823")
                .withEmail("ags@asdjsjd.com").build();

        
    }
}