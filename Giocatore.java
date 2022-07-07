import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Giocatore extends Thread {
	
	int maniGiocate = 0;
	private int[] giocate;
	int idGiocatore;
	int giocateTotali;
	CyclicBarrier b;
	
	public Giocatore(int id, CyclicBarrier barriera, int numGiocate) {
		this.setName("giocatore "+id);
		idGiocatore = id;
		giocateTotali = numGiocate;
		b = barriera;
		giocate = new int[numGiocate];
		this.start();
	}
	
	public void run() {
		for(int i = 0; i< giocateTotali; i++) {
			giocata(idGiocatore, (int) (((new Random()).nextInt(10))+1) );
			try {
				b.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName()+" gioco la mano "+maniGiocate);
		}
		int tot = 0;
		for(int j = 0; j< giocateTotali; j++) {
			tot += giocate[j];
		}
		System.out.println(this.getName() + " totale giocato:"+tot);
	}
	
	private void giocata(int idGiocatore, int carta) {
		if(giocate[idGiocatore]<0) {
			giocate[idGiocatore]=carta;
			System.out.println("Giocatore "+idGiocatore+" ha giocato "+carta);
			maniGiocate++;
		} 
	}
	
	
}
