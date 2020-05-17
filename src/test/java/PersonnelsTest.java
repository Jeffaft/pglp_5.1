import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*
;public class PersonnelsTest {

	@Test
	public void PersonnelsSeria() {
		try {
			Personnels p = new Personnels.Builder("ju","rey","directeur").build();
			
			File fichier =  new File("test.io");
			
			//ecriture dans le fichier
			FileOutputStream out = new FileOutputStream("test.io");
	        ObjectOutputStream oout = new ObjectOutputStream(out);
	        oout.writeObject(p);
	        oout.close();
	    
	        //lecture dans le fichier
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.io"));
	        Personnels p2 = (Personnels) ois.readObject();
	        ois.close();
	        
	        //vérification
	        System.out.println(p.toString());
	        System.out.println(p2.toString());
	        assertEquals(p.toString(),p2.toString());
	        
		} catch (Exception ex) {
	         ex.printStackTrace();
	      }
		
	}
	@Test
	public void CompositeSeria() {
		try {
			Personnels p=new Personnels.Builder("ju","rey","dev1").build();
			Personnels p1=new Personnels.Builder("ju","rey2","dev2").build();
			CompositePersonnels equipe= new CompositePersonnels();
			equipe.add(p);
			equipe.add(p1);
			
			File fichier =  new File("test.io");
			
			//ecriture dans le fichier
			FileOutputStream out = new FileOutputStream("test.io");
	        ObjectOutputStream oout = new ObjectOutputStream(out);
	        oout.writeObject(equipe);
	        oout.close();
	    
	        //lecture dans le fichier
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.io"));
	        CompositePersonnels equipe2 = (CompositePersonnels) ois.readObject();
	        ois.close();
	        
	        //vérification
	        System.out.println(equipe.toString());
	        System.out.println(equipe2.toString());
	        assertEquals(equipe.toString(),equipe2.toString());
	        
		} catch (Exception ex) {
	         ex.printStackTrace();
	      }
		
	}
	
	@Test
	public void PersonnelsDAOwriteTest() {
		try {
			Personnels p = new Personnels.Builder("ju","rey","directeur").build();
			DAO<Personnels> pDAO = FabriqueDAO.getPersonnelsDAO();
			
			//utilisation de la fabrique et du DAO
			pDAO.write(p, "juTest.io");
	    
	        //lecture dans le fichier pour verif
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("juTest.io"));
	        Personnels p2 = (Personnels) ois.readObject();
	        ois.close();
	        
	        //vérification
	        System.out.println(p.toString());
	        System.out.println(p2.toString());
	        assertEquals(p.toString(),p2.toString());
	        
		} catch (Exception ex) {
	         ex.printStackTrace();
	      }
	}
	
	@Test
	public void PersonnelsDAOreadTest() {
		Personnels p = new Personnels.Builder("ju","rey","directeur").build();
		
		//lecture depuis le fichier voulu ( objet déjà sérialisé)
		DAO<Personnels> pDAO = FabriqueDAO.getPersonnelsDAO();
		Personnels p2 = pDAO.read("juTest.io");
		
		//vérification 
		assertEquals(p.toString(),p2.toString());
		
	}
		
	@Test
	public void CompositePersonnelsDAOwriteTest() {
		try {
			
			//création des objet à sérialiser
			Personnels p=new Personnels.Builder("ju","rey","dev1").build();
			Personnels p1=new Personnels.Builder("ju","rey2","dev2").build();
			CompositePersonnels equipe= new CompositePersonnels();
			equipe.add(p);
			equipe.add(p1);
			
			//appel de la fabrique et serialisation dans un fichier
	        DAO<CompositePersonnels> cpDAO = FabriqueDAO.getCompositePersonnelsDAO();
	        cpDAO.write(equipe, "equipe1.io");
	        
	        //lecture pour le test
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("equipe1.io"));
	        CompositePersonnels equipe2 = (CompositePersonnels) ois.readObject();
	        ois.close();
	        
	        //vérification
	        System.out.println(equipe.toString());
	        System.out.println(equipe2.toString());
	        assertEquals(equipe.toString(),equipe2.toString());
        
		} catch (Exception ex) {
         ex.printStackTrace();
      }
	}
	
	@Test
	public void CompositePersonnelsDAOreadTest() {
		//création des objet à comparer
		Personnels p=new Personnels.Builder("ju","rey","dev1").build();
		Personnels p1=new Personnels.Builder("ju","rey2","dev2").build();
		CompositePersonnels equipe= new CompositePersonnels();
		equipe.add(p);
		equipe.add(p1);
		
		//lecture depuis le fichier voulu ( objet déjà sérialisé)
		DAO<CompositePersonnels> cpDAO = FabriqueDAO.getCompositePersonnelsDAO();
		CompositePersonnels equipe2 = cpDAO.read("equipe1.io");
		
		//vérification
        System.out.println(equipe.toString());
        System.out.println(equipe2.toString());
        assertEquals(equipe.toString(),equipe2.toString());
	}
	

}
