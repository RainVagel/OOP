/**
 * Created by rainvagel on 21/03/15.
 */
public class Peaklass {
    public static void main(String[] args) {
        Ruudustik mäng = new Ruudustik(9);
        Väljastus game = new Väljastus(mäng);
        game.väljasta();
    }
}
