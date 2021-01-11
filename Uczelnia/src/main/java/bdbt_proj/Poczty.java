package bdbt_proj;

public class Poczty {
	
	/* Filed from database */
	private int nr_poczty;
	private String poczta;
	private String kod_poczty;
	
	public Poczty() {
		
	}

	/* Constructor */
	public Poczty(int nr_poczty, String poczta, String kod_poczty) {
		super();
		this.nr_poczty = nr_poczty;
		this.poczta = poczta;
		this.kod_poczty = kod_poczty;
	}

	/* Getters and setters */
	public int getNr_poczty() {
		return nr_poczty;
	}

	public void setNr_poczty(int nr_poczty) {
		this.nr_poczty = nr_poczty;
	}

	public String getPoczta() {
		return poczta;
	}

	public void setPoczta(String poczta) {
		this.poczta = poczta;
	}

	public String getKod_poczty() {
		return kod_poczty;
	}

	public void setKod_poczty(String kod_poczty) {
		this.kod_poczty = kod_poczty;
	}

	/* toString() */
	@Override
	public String toString() {
		return "Poczty [nr_poczty=" + nr_poczty + ", poczta=" + poczta + ", kod_poczty=" + kod_poczty + "]";
	}
	
	
	
}
