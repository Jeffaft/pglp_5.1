
import java.lang.Iterable;
import java.util.Iterator;

import java.util.List; 
import java.util.ArrayList;

import java.io.Serializable;;

public class CompositePersonnels implements PersInterface, Serializable {
	private List<PersInterface> childPersonnels = new ArrayList<PersInterface>();
	@Override
	public void print_hierarchique() {
		for(PersInterface p : childPersonnels) {
			p.print_hierarchique();
		}
	}
	public void print_groupe() {
		//
	}
	public void add(PersInterface p) {
		childPersonnels.add(p);
	}
	
	public void remove(PersInterface p) {
		childPersonnels.remove(p);
	}
	
	public String toString() {
		String str = "";
		for(PersInterface p : childPersonnels) {
			str = str + p.toString();
		}
		return str;
	}
}
