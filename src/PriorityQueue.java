public class PriorityQueue<T> {
    private final int size;
    private final Patients[] heap;
    PriorityQueue(int size){
        this.size = size;
        heap = new Patients[size];
    }
    public void insert(Patients record){
        heap[0] = record;
        System.out.println(heap[0].getAddress());
    }
    private int getParent(int location){
        return (location - 1) / 2;
    }
}
