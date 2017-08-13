import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Entropy {
	 public static int[] charCount(String s){
		 HashMap<Character,Integer> hashmap = new HashMap<Character,Integer>();
		 char[] s1 = s.toCharArray();
		 
		 for(int i =0;i<s1.length;i++){
			 int index = 0;
			 for(int j=0;j<s1.length;j++){
				 if(s1[i]==s1[j]){
					 index++;
				 }
			 }
			 hashmap.put(s1[i], index);
		 }
		Character[] keysets =  hashmap.keySet().toArray(new Character[hashmap.size()]);
		Arrays.sort(keysets);
		
		int[] returnvalue = new int[hashmap.size()];
		for(int i = 0;i<returnvalue.length;i++){
			returnvalue[i] = hashmap.get(keysets[i]);
		}
		return returnvalue;
	}
	 
	 public static double[] normalise(int[] c){
		 double sum = 0;
		 for(int i=0;i<c.length;i++){
			 sum += c[i];
		 }
		
		 double[] c1 = new double[c.length];
				 
		 for(int i=0;i<c1.length;i++){
			 c1[i] = c[i]/sum;
		 }
		 
		 return c1;
	 }
	 
	 public static double entropyOf(double[] p){
		 double sum = 0;
		 for(int i = 0;i<p.length;i++){
			 sum-= p[i]*Math.log(p[i]);
		 }
		sum =Double.parseDouble(String.format( "%.4f", sum));
		 return sum;
	 }
	 
	
	 
	 public static ArrayList<Character> uniqueletters(String[] a){
		 ArrayList<Character> result = new ArrayList<Character>();
		 char[] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		 for(char letter:arr){
			 int index=0;
			 for(String str:a){
				 if(str.indexOf(letter)!=-1){
					 index++;
				 }
			 }
			 
			 if(index==1){
				 result.add(letter);
			 }
		 }
		 return result;
	 }
	 public static int[][] charCountArray(String[] a){
		 int[][] result =new  int[a.length][];
		 for(int i=0;i<a.length;i++){
			 char[] chars =a[i].toCharArray();
			 String output = "" ;
			 for(char achar:chars){
				 if(uniqueletters(a).contains(achar)){
					 output += achar;
					 
				 }
			 }
			 result[i] = charCount(output);
			 
		 }
		 
		 
		 return result;
	 }
	 

	 public static void main(String[] args) {
		 
		
	System.out.println(Arrays.toString(       charCountArray(new String[] {"abbcccxx","bbccyzdd"})         ));
	
	
	 
}
}