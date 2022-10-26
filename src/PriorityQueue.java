public class PriorityQueue<T> {
    private int size = 0;
    private final Patients[] heap;
    PriorityQueue(int size){
        heap = new Patients[size];
    }
    public void display(){
        for(Patients i : heap){
            System.out.println("status: "+i.getUNOS_Status() + " age: " + i.getDateOfBirth());
        }
    }
    public void insert(Patients record){
        heap[size] = record;
        shiftUp(size);
        size++;
    }
    public String peek(){
        return heap[0].toString();
    }


    private int getParent(int location){
        return (location - 1) / 2;
    }
    private void shiftUp(int location){
        while(true){
            // First priority
            if (heap[location].getUNOS_Status() > heap[getParent(location)].getUNOS_Status()){
                swap(getParent(location), location);
                location = getParent(location);
            }
            // Second priority
            else if (heap[location].getUNOS_Status() == heap[getParent(location)].getUNOS_Status()){
                if (heap[location].getDateOfBirth() < heap[getParent(location)].getDateOfBirth()){
                    swap(getParent(location), location);
                    location = getParent(location);
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
    }
    private void swap(int parent, int current){
        Patients temp = heap[parent];
        heap[parent] = heap[current];
        heap[current] = temp;
    }


}
