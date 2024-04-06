import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> countries = new ArrayList<>();
        countries.add("Argentina");
        countries.add("Chile");
        countries.add("Bolivia");
        countries.add("Peru");
        countries.add("Uruguay");
        countries.add("Paraguay");

        Optional<String> country = countries.stream().filter(c -> c.equalsIgnoreCase("Argentina")).findFirst();

        country.ifPresent(System.out::println);

    }

    public static void exampleOptionals(){
        Optional<Double> result = averageScores(7.0,4.2,3.4,2.2);
        if(result.isPresent()){
            System.out.println("Results: " + result.get());
        }else{
            System.out.println("Nothing");
        }
    }

    public static Optional<Double> averageScores(Double... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        double sum = 0;
        for (Double score : scores) {
            sum += score;
        }
        return Optional.of(sum / scores.length);
    }
}