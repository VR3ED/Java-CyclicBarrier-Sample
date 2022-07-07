import java.util.Random;
import java.util.concurrent.CyclicBarrier;
public class MainGioco {
	static final int numGiocatori=4;
	static final int numGiocate = 10;
	Random rnd;
	
	void exec() {

		//mie modifiche
		
		CyclicBarrier partita = new CyclicBarrier(numGiocatori, new Albitro(numGiocate));
		
		for(int id=0; id<numGiocatori; id++) {
			Giocatore g1 = new Giocatore(id, partita, numGiocate);
		}
		
	}

	
	public static void main(String[] args) {
		new MainGioco().exec();
	}
}
