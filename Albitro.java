
public class Albitro implements Runnable {

	int numGiocate = 1;
	int GiocateTotali;
	
	public Albitro(int numgiocate) {
		GiocateTotali = numgiocate;
	}

	@Override
	public void run() {
		System.out.print("Sono l'ablitro: parte il gioco,");
		if(numGiocate ==GiocateTotali) {
			System.out.println("ultimo turno");
		}
		else {
			System.out.println("turno "+numGiocate);
			numGiocate++;
		}
	}
	
}
