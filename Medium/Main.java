//Name of challenge is PERMUTATION STEP
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main 
{
    static ArrayList<Integer> findCombination(int[] array, int pos,ArrayList<Integer> result_set)
    { 
        if(pos >= array.length - 1)
        {   
            int num=0;  
            for(int i = 0; i < array.length - 1; i++)
            {    
                num=num*10+array[i];  
            }  
            if(array.length > 0)   
                num=num*10+array[array.length-1];  
            if (!result_set.contains(num))
                result_set.add(num);
        }  
  
        for(int i = pos; i < array.length; i++)
        {   
            int t = array[pos];  
            array[pos] = array[i];  
            array[i] = t;  
            findCombination(array, pos+1,result_set);  
            t = array[pos];  
            array[pos] = array[i];  
            array[i] = t;  
        }  
        return result_set;
    }  
    public static int PermutationStep(int num)
    {
        String str_num=Integer.toString(num);
        int index=0;
        int largest=Integer.parseInt(Character.toString(str_num.charAt(str_num.length()-1)));
        int i;
        for (i=str_num.length()-2;i>=0;i--)
        {
            if (largest<Integer.parseInt(Character.toString(str_num.charAt(i))))
            {
                largest=Integer.parseInt(Character.toString(str_num.charAt(i)));
            }
            else
            {
                index=i;
                break;
            }
        }
        if(i<0)
            return -1;
        int partial=Integer.parseInt(str_num.substring(index));
        String str_partial=Integer.toString(partial);
        int arr[]=new int[str_partial.length()];
        for(i=0;i<arr.length;i++)
            arr[i]=Integer.parseInt(Character.toString(str_partial.charAt(i)));
        ArrayList<Integer> result_set=new ArrayList<Integer>();
        result_set=findCombination(arr,0,result_set);
        Collections.sort(result_set);
        //System.out.println(result_set);
        int final_result=result_set.get(Collections.binarySearch(result_set,partial)+1);
        final_result=Integer.parseInt(str_num.substring(0,index) + Integer.toString(final_result));
        //System.out.println(str_num.substring(0,index+1));
        return final_result;    
    }
    
    public static void main(String[] args) 
    {
        Scanner  scan=new Scanner(System.in);
        System.out.println("Enter number");
        int num=scan.nextInt();
        int result=PermutationStep(num);
        System.out.println("Next greater number is "+result);
        scan.close();;
    }
}
