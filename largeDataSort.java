import java.io.*;
import java.util.*;
public class largeDataSort
{
    public static void main (String [] args) throws IOException
    {

        generatorB();
        int[] array1Selection = new int [2000];
        int[] array2Selection = new int [2000];
        int[] array3Selection = new int [2000];
        int[] array1Bubble = new int [2000];
        int[] array2Bubble = new int [2000];
        int[] array3Bubble = new int [2000];
        int[] array1Insertion = new int [2000];
        int[] array2Insertion = new int [2000];
        int[] array3Insertion = new int [2000];

        Scanner scan1 = new Scanner(new File("sorted2000.txt"));
        Scanner scan2 = new Scanner(new File("reverse2000.txt"));
        Scanner scan3 = new Scanner(new File("random2000.txt"));
        Scanner scan4 = new Scanner(new File("sorted2000.txt"));
        Scanner scan5 = new Scanner(new File("reverse2000.txt"));
        Scanner scan6 = new Scanner(new File("random2000.txt"));
        Scanner scan7 = new Scanner(new File("sorted2000.txt"));
        Scanner scan8 = new Scanner(new File("reverse2000.txt"));
        Scanner scan9 = new Scanner(new File("random2000.txt"));

        int count = 0;

        while(scan1.hasNext()){
            array1Selection[count] = scan1.nextInt();
            array2Selection[count] = scan2.nextInt();
            array3Selection[count] = scan3.nextInt();            
            array1Bubble[count] = scan4.nextInt();
            array2Bubble[count] = scan5.nextInt();
            array3Bubble[count] = scan6.nextInt();
            array1Insertion[count] = scan7.nextInt(); 
            array2Insertion[count] = scan8.nextInt();
            array3Insertion[count] = scan9.nextInt();
            count++;

        }

        System.out.println (" --- best case ---");
        selectionSort (array1Selection);
        System.out.println (" --- worst case ---");
        selectionSort (array2Selection);
        System.out.println (" --- avarage case ---");
        selectionSort (array3Selection); 
        System.out.println (" --- best case ---");
        bubbleSort (array1Bubble);
        System.out.println (" --- worst case ---");
        bubbleSort (array2Bubble);
        System.out.println (" --- avarage case ---");
        bubbleSort (array3Bubble);
        System.out.println (" --- best case ---");
        insertionSort (array1Insertion);
        System.out.println (" --- worst case ---");
        insertionSort (array2Insertion);
        System.out.println (" --- avarage case ---");
        insertionSort (array3Insertion);
        System.out.println (" --- best case ---");

    }
  

    public static void generatorB()throws IOException {
        PrintWriter output1 = new PrintWriter(new FileWriter("sorted1000.txt"));
        PrintWriter output2 = new PrintWriter(new FileWriter("reverse1000.txt"));
        PrintWriter output3 = new PrintWriter(new FileWriter("random1000.txt"));
        
       
        Random numGen = new Random();
        for (int i = 1; i < 1001; i++){
            output1.print(i + " ");        

        }
        
        for(int i = 0; i < 1001; i++){
            int a = numGen.nextInt(2000)+1;
            output3.print(a + " " );

        }       

        output1.close();
        output2.close();
        output3.close();

    }

    public static void selectionSort(int[] array) {
        int temp, min, exchanges = 0, comparisons = 0;
        int numberOfItems = array.length;
        for (int pass=0; pass != numberOfItems - 1; pass++) {
            min = pass;
            for (int index = pass+1; index != numberOfItems; index++) {
                comparisons++;
                if (array[index] < array[min])
                    min = index;
            } // end inner loop
            temp = array[min];
            array[min] = array[pass];
            array[pass] = temp;
            exchanges++;

        } // end outer loop
        System.out.println("Selection Sort: Number of Exchanges: " +
            exchanges);
        System.out.println("Selection Sort: Number of Comparisons: " +
            comparisons);
        System.out.println ("Sorted file:");
        for (int i= 0; i < 10; i++)
            System.out.print (array[i] + " ");
        System.out.println ();
    } // end selection sort
    public static void bubbleSort(int[]array) {
        int exchanges = 0, comparisons = 0;
        boolean cont = true;
        int numberOfItems = array.length;
        for(int pass=1;pass !=numberOfItems;pass++) {
            cont = false;
            for(int index = 0 ;index!= numberOfItems - pass;index++) {
                comparisons++;
                if(array[index]>(array[index+1])) {

                    int temp=array[index];
                    array[index]=array[index+1];
                    array[index+1]=temp;
                    exchanges++;
                    cont = true;
                }

            }

        }

        System.out.println("Bubble Sort: Number of Exchanges: " +
            exchanges);
        System.out.println("Bubble Sort: Number of Comparisons: " +
            comparisons);
        System.out.println ("Sorted file:");       
        for (int i= 0; i < 10; i++)
            System.out.print (array[i] + " ");
        System.out.println ();
    }

    private static void insertionSort(int[] array) {
        int exchanges = 0, comparisons = 0;
        boolean cont = true;
        int numberOfItems = array.length;
        for(int pass=1;pass<numberOfItems;pass++) {
            int index=pass-1;
            int temp=array[pass];
            cont = false;

            while(index>=0 && array[index]>temp) {
                array[index+1]=array[index];
                index--;
                comparisons++;
                exchanges++;

            }
            array[index+1]=temp;            
        }
        System.out.println("Insertion Sort: Number of Exchanges: " +
            exchanges);
        System.out.println("Insertion Sort: Number of Comparisons: " +
            comparisons);
        System.out.println ("Sorted file:");       
        for (int i= 0; i < 10; i++)
            System.out.print (array[i] + " ");
        System.out.println ();
    }
}
