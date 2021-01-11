package bdbt_proj;

public class Uczelnie {

	/* Filed from database */
	private int nr_Uczelnia;
	private String nazwa_U;
	private String data_zalozenia;
	private String mail;
	private String telefon;
	private int nr_adresu;

	public Uczelnie() {

	}

	/* Constructor */
	public Uczelnie(int nr_Uczelnia, String nazwa_U, String data_zalozenia, String mail, String telefon,
			int nr_adresu) {
		super();
		this.nr_Uczelnia = nr_Uczelnia;
		this.nazwa_U = nazwa_U;
		this.data_zalozenia = data_zalozenia;
		this.mail = mail;
		this.telefon = telefon;
		this.nr_adresu = nr_adresu;
	}

	/* Getters and setters */
	public int getNr_Uczelnia() {
		return nr_Uczelnia;
	}

	public void setNr_Uczelnia(int nr_Uczelnia) {
		this.nr_Uczelnia = nr_Uczelnia;
	}

	public String getNazwa_U() {
		return nazwa_U;
	}

	public void setNazwa_U(String nazwa_U) {
		this.nazwa_U = nazwa_U;
	}

	public String getData_zalozenia() {
		return data_zalozenia;
	}

	public void setData_zalozenia(String data_zalozenia) {
		this.data_zalozenia = data_zalozenia;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getNr_adresu() {
		return nr_adresu;
	}

	public void setNr_adresu(int nr_adresu) {
		this.nr_adresu = nr_adresu;
	}

	/* toString() */
	@Override
	public String toString() {
		return "Uczelnie [nr_Uczelnia=" + nr_Uczelnia + ", nazwa_U=" + nazwa_U + ", data_zalozenia=" + data_zalozenia
				+ ", mail=" + mail + ", telefon=" + telefon + ", nr_adresu=" + nr_adresu + "]";
	}

}
