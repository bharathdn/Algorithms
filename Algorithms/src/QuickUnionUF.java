
public class QuickUnionUF {
	
	private int [] array;
	
	public QuickUnionUF(int N) {
		array = new int[N];
		for(int i = 0; i < N; i++) {
			array[i] = i;
		}
	}
	
	public int Root(int i) {
		while(i != array[i]) {
			i = array[i];
		}
		return i;
	}
	
	public boolean Connected(int x, int y) {
		return (Root(x) == Root(y));
	}
	
	public void Union(int x, int y) {
		if(Connected(x, y))
			return;
		
		int rootX = Root(x);
		int rootY = Root(y);
		
		// set y's root as parent to x's root
		array[rootX] = rootY; 
	}
}