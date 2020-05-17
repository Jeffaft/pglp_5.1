import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CompositePersonnelsDAO implements DAO<CompositePersonnels> {
	public CompositePersonnelsDAO() {
		
	}
	@Override
	public CompositePersonnels read(String file) {
		CompositePersonnels cp = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
	        cp = (CompositePersonnels) ois.readObject();
	        ois.close();
	        
		}
        catch (Exception ex) {
	         ex.printStackTrace();
	      }
		return cp;
	}
	
	@Override
	public void write(CompositePersonnels cp,String file) {
		
	}
	
	@Override
	public void update (CompositePersonnels cp,String file) {
		
	}
}
