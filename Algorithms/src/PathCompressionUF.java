public class PathCompressionUF {
	
	private int [] array;
	private int [] sizeArray;
	
	public PathCompressionUF(int N){
		array = new int[N];
		sizeArray = new int[N]; 
		for(int i=0; i<N; i++){
			array[i] = i;
			sizeArray[i] = 1;
		}
	}
	
	public int Root(int i){
		while(i != array[i]){
			array[i] = array[array[i]];
			i = array[i];
		}
		return i;
	}
	
	public boolean Connected(int x, int y){
		return (Root(x) == Root(y));
	}
	
	public void Union(int x, int y){
		if(Connected(x,y))
			return;
		
		int rootX = Root(x);
		int rootY = Root(y);
		
		// set the tree with largest size (of the two) as parent
		if(sizeArray[x] > sizeArray[y]){
			array[rootY] = rootX;
			sizeArray[rootX] += sizeArray[rootY];
 		}
		else{
			array[rootX] = rootY;
			sizeArray[rootY] += sizeArray[rootX];
		}
	}
}