package Entity.Concrete;

public class User {
	
	private int id;
	private String ad;
	private String soyad;
	private String parola;
	private String eposta;
	
	public User() {}

	public User(int id, String ad, String soyad, String parola, String eposta) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.parola = parola;
		this.eposta = eposta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}


}
