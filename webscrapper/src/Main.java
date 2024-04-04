import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // Descargar webs
        List<String> links = new ArrayList<>();
        links.add("https://www.bbc.com/");
        links.add("https://www.bbc.com/news/uk-61196071");
        links.add("https://www.bbc.com/news/uk-61194137");
        links.add("https://www.bbc.com/news/world-us-canada-61196311");

       /* // Procesar cada enlace y imprimir el contenido
        links.stream().parallel().forEach(link -> {
            String content = getWebContent(link);
            System.out.println(content);
        });*/

        // Imprimir el contenido de la última URL
        String link = "https://www.bbc.com/";
        String result = getWebContent(link);
        //System.out.println(result);

    }

    private synchronized static String getWebContent(String link) {

        System.out.println("INIT");
        System.out.println(link);

        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream input = conn.getInputStream();

            Stream<String> lines = new BufferedReader(new InputStreamReader(input)).lines();

            System.out.println("END");

            return lines.collect(Collectors.joining());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
