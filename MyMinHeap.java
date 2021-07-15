public class MyMinHeap implements MinHeap_Interface{
	
    //Declare variables
    private int[] Heap; 
    private int size = 0; 
    private int maxsize = 20; 
  
    private static final int FRONT = 1; 
    
    //Add method for the heap
	@Override
	public void add(int x) {
		 
        if (size >= maxsize) { 
          maxsize += 4;
        }
        
        Heap[++size] = x; 
        int current = size;
  
        while (Heap[current] < Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
	}
	@Override
	public int get() {
		// TODO Auto-generated method stub
		if(Heap == null) {
			System.out.println("The Heap is empty");
			return -1;
		}
		return 0;
	}
    //Min Heap
    public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
        	minHeapDown(pos); 
        } 
    } 
    
    //Remove the top item in the heap
	@Override
	public int remove() 
    { 
		if(Heap == null) {
			return 0;
		}
		else {
			 int item = Heap[FRONT]; 
		        Heap[FRONT] = Heap[size--]; 
		        minHeapDown(FRONT); 
		        return item; 
		}
    } 
	
	//Replace the first item in the heap
	@Override
	public void replace(int x) {
		// TODO Auto-generated method stub
		if(Heap[0] == 0) {
			return;
		}
		Heap[0] = x;
	}

	@Override
	public void clear() {
	}

	//If the Heap is null 
	//return true
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		if(Heap.length == 0) {
			return 0;
		}
		while(Heap.length != 0) {
			count++;
		}
		return count;
	}

    // Function to return the position of 
    // the parent for the node currently 
    // at pos 
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    // Function to return the position of the 
    // left child for the node currently at pos 
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
  
    // Function to return the position of 
    // the right child for the node currently 
    // at pos 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
    
 // Function that returns true if the passed 
    // node is a leaf node 
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    // Function to swap two nodes of the heap 
    private void swap(int first, int second) 
    { 
        int tmp;
        //Set the temp to the first Heap
        tmp = Heap[first];
        //Set the first Heap become Second Heap
        Heap[first] = Heap[second]; 
        //Let the second heap become tmp to swap around
        Heap[second] = tmp; 
    } 
   
    // Function to heapify the node at position
    private void minHeapDown(int postion) 
    { 
  
        // If the node is a non-leaf node and greater 
        // than any of its child 
        if (!isLeaf(postion)) { 
            if (Heap[postion] > Heap[leftChild(postion)] 
                || Heap[postion] > Heap[rightChild(postion)]) { 
  
                // Swap with the left child and heapify 
                // the left child 
                if (Heap[leftChild(postion)] < Heap[rightChild(postion)]) { 
                    swap(postion, leftChild(postion)); 
                    minHeapDown(leftChild(postion)); 
                } 
  
                // Swap with the right child and heapify 
                // the right child 
                else { 
                    swap(postion, rightChild(postion)); 
                    minHeapDown(rightChild(postion)); 
                } 
            } 
        } 
    } 
	//Constructor of Min Heap
	public MyMinHeap(int maxsize){
		this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = 0; 
	}
	
}
