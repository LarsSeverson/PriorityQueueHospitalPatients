import java.io.*;

public class Main {
    private static int fileSize = -1;
    private static PriorityQueue<Object> hospitalQueue;
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader theFile = new BufferedReader(new FileReader("inputFile.txt"));
        try{
            theFile.readLine();
        }
        catch(IOException e){

        }
        hospitalQueue = new PriorityQueue<>(getSize(theFile));
        insertRecords(theFile);
    }
    private static void insertRecords(BufferedReader fileName){
        String line;
        int i = 0;
        try{
            System.out.println(fileName.readLine());
            while((line = fileName.readLine()) !=  null){
                if (i > 0){
                    String[] info = line.split(";");
                    hospitalQueue.insert(
                            new Patients(info[0], info[1], info[2], info[3],
                                         info[4], info[5], info[6], info[7],
                                         info[8], info[9], info[10], info[11],
                                         info[12]));
                }
                // skip first line
                i++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static int getSize(BufferedReader fileName){
        try{
            while(fileName.readLine() != null){
                fileSize++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return fileSize;
    }
}
