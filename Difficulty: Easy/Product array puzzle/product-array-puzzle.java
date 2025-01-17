//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n=arr.length;
        int pre[]=new int[n];
        int suf[]=new int[n];
        int res[]=new int[n];
        pre[0]=arr[0];
        suf[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            pre[i]=arr[i]*pre[i-1];
           // System.out.print(pre[i]+" ");
        }
        for(int i=n-2;i>=0;i--){
            suf[i]=arr[i]*suf[i+1];
        }
        for(int i=0;i<n;i++){
            if(i==0){
                res[0]=suf[i+1];
            }
            else if(i==n-1){
                res[i]=pre[i-1];
            }
            else{
                res[i]=pre[i-1]*suf[i+1];
            }
        }
        return res;
    }
}
