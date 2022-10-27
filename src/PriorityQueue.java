public class PriorityQueue<T> {
    private int size;
    private final Patients[] heap;
    PriorityQueue(int size){
        this.size = -1;
        heap = new Patients[size];
    }
    public void display(){
        System.out.println();
        int i = 0;
        while (i <= size){
            System.out.println("status: "+ heap[i].getUNOS_Status() + " age: " + heap[i++].getDateOfBirth());
        }
        System.out.println();
    }
    public int size(){
        return size;
    }
    public void insert(Patients record){
        heap[++size] = record;
        shiftUp(size);
    }
    public String peek(){
        System.out.println(heap[0].toString());
        return heap[0].toString();
    }

    public Patients nextPatient(){
        Patients result = heap[0];
        heap[0] = heap[size--];
        shiftDown(0);
        return result;
    }
    public Patients removePatient(int patientLocation){
        Patients result = heap[patientLocation];
        heap[patientLocation] = heap[size--];
        shiftDown(patientLocation);
        return result;
    }
    public boolean find(Patients check){
        return false;
    }
    private int getParent(int location){
        return (location - 1) / 2;
    }
    private int getLeft(int location){
        return (location * 2) + 1;
    }
    private int getRight(int location){
        return (location * 2) + 2;
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
    private void shiftDown(int location){
        if(isLeaf(location)){
            return;
        }
        if (heap[location].getUNOS_Status() < heap[getLeft(location)].getUNOS_Status()
        || heap[location].getUNOS_Status() < heap[getRight(location)].getUNOS_Status()){
            // First priorities
            if (heap[getLeft(location)].getUNOS_Status() > heap[getRight(location)].getUNOS_Status()){
                swap(getLeft(location), location);
                shiftDown(getLeft(location));
            }
            else if (heap[getLeft(location)].getUNOS_Status() < heap[getRight(location)].getUNOS_Status()){
                swap(getRight(location),location);
                shiftDown(getRight(location));
            }
            // Second priority
            else{
                if(heap[getLeft(location)].getDateOfBirth() < heap[getRight(location)].getDateOfBirth()){
                    swap(getLeft(location), location);
                    shiftDown(getLeft(location));
                }
                else{
                    swap(getRight(location), location);
                    shiftDown(getRight(location));
                }
            }
        }
    }
    private boolean isLeaf(int location){
        return (location > (size / 2) && location <= size);
    }
    private void swap(int toSwap, int current){
        Patients temp = heap[toSwap];
        heap[toSwap] = heap[current];
        heap[current] = temp;
    }


}
