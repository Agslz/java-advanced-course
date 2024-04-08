import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    private static Map<String, Double> pricesByAirlines;

    public static void main(String[] args) {
        init();

        String from = "BCN";
        String to = "JFK";

        Double lowestPrice = getLowestPrice(from,to);
        Double avgPrice = getAvgPrice(from,to);


        System.out.println("Lowest Price: "+ lowestPrice);
        System.out.println("Avg Price: "+ avgPrice);
    }

    private static Double getAvgPrice(String from, String to) {
        AtomicReference<Double> totalPrice = new AtomicReference<>(0.0);
        AtomicInteger countAirlines = new AtomicInteger(0);
        pricesByAirlines.keySet().forEach(airline -> {
            Double price = getPriceTrip(airline, from, to);
            Double result = totalPrice.get() + price;
            totalPrice.set(result);
            countAirlines.incrementAndGet();
        });

        return totalPrice.get() / countAirlines.get();
    }

    private static Double getLowestPrice(String from, String to) {
        AtomicReference<Double> lowestPrice = new AtomicReference<>(null);
        pricesByAirlines.keySet().forEach(airline -> {
            Double price = getPriceTrip(airline, from, to);
            if (lowestPrice.get() == null || lowestPrice.get() > price) {
                lowestPrice.set(price);
            }
        });
        return lowestPrice.get();
    }

    private static void init() {
        pricesByAirlines = new HashMap<>();

        pricesByAirlines.put("Aerolineas Argentinas", 200.20);
        pricesByAirlines.put("American Airlines", 2000.2234);
        pricesByAirlines.put("Us Airways", 3421.20);
        pricesByAirlines.put("Qatar Airways", 223254.20);
        pricesByAirlines.put("Avianca", 100.00);
        pricesByAirlines.put("Latam Airlines", 524.20);

    }

    private static Double getPriceTrip(String airline, String from, String to) {

//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        return pricesByAirlines.get(airline);
    }

}