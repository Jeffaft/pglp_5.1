
public enum App {
	ENVIRONNEMENT;
	public void run(String[]args) {
		 Personnels p=new Personnels.Builder("ju","rey","directeur gÃ©nÃ©ral").build();
		 Personnels p1=new Personnels.Builder("ju","rey2","chef d'Ã©quipe").build();
		 
		 Personnels p2=new Personnels.Builder("ju","rey3","cadre").build();
		 Personnels p3=new Personnels.Builder("ju","rey4","cadre").build();
		 
		 CompositePersonnels devs = new CompositePersonnels();
		 CompositePersonnels equipe= new CompositePersonnels();
		 CompositePersonnels dpt_info = new CompositePersonnels();
		 
		 devs.add(p2);
		 devs.add(p3);
		 
		 equipe.add(devs);
		 equipe.add(p1);
		 
		 dpt_info.add(p);
		 dpt_info.add(equipe);
		 dpt_info.print_hierarchique();
	}
	public static void main(String[]args) {
	ENVIRONNEMENT.run(args);
	}
}