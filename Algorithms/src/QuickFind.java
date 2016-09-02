
public class QuickFind {
	private int[] array;
	
	public QuickFind(int N){
		array = new int[N];
		for(int i=0; i<N; i++)
			array[i] = i;
	}
	
	public boolean Connected(int x, int y){
		return (array[x] == array[y]);
	}
	
	public void Union(int x, int y){
		int xId = array[x];
		int yId = array[y];
		
		// set the Id for positions which have id of first,
		// to that of value of second
		for(int i=0; i<array.length; i++){
			if(array[i] == xId){
				array[i] = yId;
			}
		}
	}
	
	public static void main(String[] args){
		
	}
}
