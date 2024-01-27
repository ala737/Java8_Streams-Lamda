import java.util.Arrays;
import java.util.List;

public class Lamda {

    public static void main(String[] args) {

        Game football = new Game() {
            @Override
            public void play() {
                System.out.println("playing football...");
            }
        };

        Game basketball = new Game() {
            @Override
            public void play() {
                System.out.println("playing basketball...");
            }
        };

        Game footballLamda = () ->
                System.out.println("palying football");


        List<String> players = Arrays.asList(
                "CR7", "Messi","Zidan", "Mbappé", "Belingham"
        );

       players.stream()
               .filter(player -> player.equalsIgnoreCase("zidan"))
               .findFirst()
               .ifPresentOrElse(
                       player ->System.out.println("Zidan is in the team"),
                       () -> System.out.println("Zidan is in the team")
               );


    }


    interface Game{
        void play();
    }
}
