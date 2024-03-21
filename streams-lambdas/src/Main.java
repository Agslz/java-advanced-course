import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> cities = new ArrayList<>();

        cities.add("London");
        cities.add("New York");
        cities.add("Barcelona");
        cities.add("Buenos Aires");
        cities.add("Tokyo");
        cities.add("Lima");
        cities.add("Bogotá");

        //Forma tradicional de recorrer un Array
        /*for(String city : cities){
            System.out.println(city);
        }*/

        //Forma funcional de recorrer un array
        /*cities.stream().forEach(city -> System.out.println(city));*/

        //Llamamos a la referencia del método
        /*cities.stream().forEach(Main::printCity);*/

        //Llamamos a la referencia del método y quitamos .stream()
        /*cities.forEach(System.out::println);*/

        // Ejemplo simple del patrón de diseño - Pipeline
        //No ejecuta el forEach de manera secuencial, divide al arreglo en pequeños lotes y los ejecuta*/
        /*cities.stream().parallel().forEach(System.out::println);*/

        //Utilizado el filter para poder hacer una búsqueda o filtro más exacto, en este caso las que empiecen con B
        //Filter recibe una expresión lambda
        /*cities.stream().filter(city -> city.startsWith("B")).forEach(System.out::println);*/

        //Filtramos las ciudades que empiecen con B y las ciudades que contengan una N
        /*cities.stream().filter(city -> city.startsWith("B"))
                .filter(city -> city.contains("n"))
                .forEach(System.out::println);*/

        //El .toList() nos ayuda a colectar lo que hayamos filtrado y transformarlo a una lista
        //Este es un metodo terminal, sin un método terminal nuestro stream nunca se ejecuta
        /*List<String> filteredCities = cities.stream().filter(city -> city.startsWith("B"))
                .filter(city -> city.contains("n")).toList();*/

    }

    public static boolean filterCity(String city) {
        return city.startsWith("B");
    }

    public static void printCity(String city) {
        System.out.println(city);
    }

}