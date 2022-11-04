public class HistoryQueue {
    private Node head;
    public HistoryQueue(){
        this.head = null;
    }
    public void add(String status, String dateListed){
        Node newNode = new Node(status, dateListed);
        newNode.next = head;
        head = newNode;
    }
    public boolean empty(){
        return head==null;
    }

    private class Node{
        private final String status;
        private final String dateListed;
        private Node next;
        private Node(String status, String dateListed){
            this.status = status;
            this.dateListed = dateListed;
            next = null;
        }
    }
    @Override
    public String toString(){
        StringBuilder data = new StringBuilder();
        Node current = head;

        while(current != null){
            data.append("Data listed on ").append(current.status).append(": ").append(current.dateListed).append("\n");
            current = current.next;
        }
        return data.toString();
    }
}
