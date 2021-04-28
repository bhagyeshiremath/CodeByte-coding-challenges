//Name of challenge is NONREPEATING CHARACTER 
import java.util.*;

class Main2
{
    public static String NonrepeatingCharacter(String str)
    {
        for(int i = 0;i<str.length();i++)
        {
            int count = 0;
            for(int j = 0;j<str.length();j++)
            {
                if(str.charAt(i)==str.charAt(j))
                {
                    count ++;
                }
            }
            if(count == 1)
            {
                return Character.toString(str.charAt(i));
            }
        }
        return " ";
    }

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println(NonrepeatingCharacter(scn.nextLine()));
        //System.out.println("Enter your stream of characters of your choice :- ");
        //char a = scn.next().charAt(0); 
    }
}
