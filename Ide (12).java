/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void func(int arr[], int max){
        
        char abc[] = new char[26];
        int p = 0;
        for (int i = 97; i <= 122; i++){
            abc[p] = (char)i;
            p++;
        }
        int n = arr.length;
        ArrayList<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        String temp = "";
        int count = max;
        while (count-- != 0){
            temp += 'a';
        }
        if (max == 0){
            temp += 'a';
        }
        ans.add(temp);
        set.add(temp);
        
        
        for (int i = 0; i < n; i++){
            String get = ans.get(ans.size() - 1);
            int x = arr[i];
            if (x == 0){
                int index3 = (int)get.charAt(get.length() - 1) - 97;
                int pro = 1;
                while (set.contains("" + abc[(index3 + pro) % 26])){
                    pro++;
                }
                char tempchar3 = abc[(index3 + pro) % 26];
                ans.add(tempchar3 + "");
                set.add(tempchar3 + "");
                continue;
                
            }
            String newstr = "";
            int j = 0;
            for (j = 0; j < x && j < get.length(); j++){
                newstr = newstr + get.charAt(j);
            }
            int index = (int)get.charAt(get.length() - 1) - 97;
            char tempchar = abc[(index + 1) % 26];
            if (x >= get.length()){
                while (j < x){
                    get = get + tempchar;
                    newstr = newstr + tempchar;
                    tempchar = (char)(tempchar++);
                    j++;
                }
                while (set.contains(newstr + (char)tempchar)){
                    int num = (int)tempchar - 97;
                    char chch = abc[(num + 1) % 26];
                    tempchar = chch;
                }
                newstr += (char)tempchar;
                int num10 = (int)tempchar - 97;
                char chch10 = abc[(num10 + 1) % 26];
                get = get + chch10;
                ans.set(ans.size() - 1, get);
                set.add(newstr);
                ans.add(newstr);
            }else{
                /*if (newstr.equals(get.substring(newstr.length()))){
                    int index2 = (int)newstr.charAt(newstr.length() - 1) - 97;
                    char tempchar2 = abc[(index2 + 1) % 26];
                    newstr = newstr + tempchar2;
                }*/
                newstr = newstr + tempchar;
                set.add(newstr);
                ans.add(newstr);
                
            }
        }
        
        for (int i = 0; i < n + 1; i++){
            System.out.println(ans.get(i));
        }
        //System.out.println("------------");
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- != 0){
		    int n = s.nextInt();
		    int arr[] = new int[n];
		    int max = 0;
		    for (int i = 0; i < n; i++){
		        arr[i] = s.nextInt();
		        max = Math.max(arr[i], max);
		    }
		    func(arr, max);
		}
	}
}
