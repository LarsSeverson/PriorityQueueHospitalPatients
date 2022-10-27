import java.util.Objects;

public class PriorityQueue<T> {
    private int size;
    private final Patients[] heap;
    PriorityQueue(int size){
        this.size = -1;
        heap = new Patients[size];
    }
    public int size(){
        return size + 1;
    }
    public void insert(Patients record){
        heap[++size] = record;
        shiftUp(size);
    }
    public String peek(){
        System.out.println(heap[0]);
        return heap[0].toString();
    }

    public Patients nextPatient(){
        Patients result = heap[0];
        heap[0] = heap[size--];
        shiftDown(0);
        return result;
    }
    public void removePatient(int patientLocation){
        if (patientLocation == -1){
            System.out.println("\nThe requested patient's record is not found.");
            return;
        }
        heap[patientLocation].setUNOS_Status(heap[0].getUNOS_Status() + 1);
        shiftUp(patientLocation);
        nextPatient();
        System.out.println("\nThe requested patient's record has been removed from the queue.");
    }
    public int find(Patients check){
        int it = 0;
        int location = -1;
        for(Patients current : heap){
            if(check.getFirstName().equals(current.getFirstName())
            && check.getLastName().equals(current.getLastName())
            && check.getFullDOB().equals(current.getFullDOB())
            && check.getAddress().equals(current.getAddress())
            && check.getCity().equals(current.getCity())
            && check.getCounty().equals(current.getCounty())
            && check.getState().equals(current.getState())
            && check.getZip().equals(current.getZip())
            && check.getPhone1().equals(current.getPhone1())
            && check.getPhone2().equals(current.getPhone2())
            && check.getEmail().equals(current.getEmail())
            && check.getFullUNOS().equals(current.getFullUNOS())){
                location = it;
                break;
            }
            if(it == size){
                break;
            }
            it++;
        }
        return location;
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
