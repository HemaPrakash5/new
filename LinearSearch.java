import java.util.*;
public class LinearSearch {
    public static void main(String[]args){
        int[]arr={22,34,52,37,82,49};
        int target=82;
        int e=arr.length-1;
        System.out.println(search(arr,target,0,e));
    }
    static int search(int[]arr,int target,int s,int e){
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(arr[m]==target){
            return m;
        }
        if(target<arr[m]){
            return search(arr,target,0,m-1);
        }
        return search(arr,target,m+1,e);
    }
}
