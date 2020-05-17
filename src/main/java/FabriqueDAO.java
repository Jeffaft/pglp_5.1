
public class FabriqueDAO {
	
	public static DAO<Personnels> getPersonnelsDAO(){
		return new PersonnelsDAO();
	}
	
	public static DAO<CompositePersonnels> getCompositePersonnelsDAO(){
		return new CompositePersonnelsDAO();
	}
}
