import java.time.LocalDate;
import java.util.List;
import java.io.*;

public final class Personnels implements PersInterface, Serializable{
	private String nom;
	private String prenom;
	private String fonctions;
	private LocalDate date;
	private List<Integer> tel;
	
	@Override
	public void print_hierarchique() {
		System.out.println("Nom: " + nom +" prÃ©nom: "+ prenom + " Fonction: " + fonctions);
	}
	public static class Builder {
		private final String nom;
		private final String prenom;
		private String fonctions;
		private LocalDate date;
		private List<Integer>tel;
		public Builder(String n,String p,String f) {
			nom = n;
			prenom = p;
			fonctions = f;
		}
			
		public Builder date(LocalDate d) {
			date = d;
			return this;
		}
		
		public Builder tel(List<Integer> tel) {
			this.tel = tel;
			return this;
		}
		public Personnels build() {
			return new Personnels(this);
		}
	}
	private Personnels(Builder Builder) {
		this.nom = Builder.nom;
		this.prenom = Builder.prenom;
		this.fonctions = Builder.fonctions;
		this.date = Builder.date;
		this.tel = Builder.tel;
		
	}
	
	public String toString() {
		return this.nom +";"+ this.prenom +";"+ this.fonctions +"\n";
	}
	
	
}
