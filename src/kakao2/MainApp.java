package kakao2;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Dart score: ");
         String inputVal = scanner.nextLine();
         
         int len      = inputVal.length();
         int step     = 1; 
         int lenPos   = 0;
         int[] score  = new int[3];
         int scorePos = 0;
         
         while(lenPos < len) {
        	 String target = inputVal.substring(lenPos, lenPos + 1);
        	 if(step == 1) {
        		 try {
					
        			 score[scorePos] = Integer.parseInt(target);
        			 step++;
				} catch (Exception e) {
					
					if("*".equals(target)) {
						
						score[scorePos - 1] = score[scorePos - 1] * 2;
						if(scorePos > 1) {
							score[scorePos - 2] = score[scorePos - 2] * 2;
						}
					}else if("#".equals(target)) {
						score[scorePos - 1] = score[scorePos - 1] * (-1);
					}
					else {
						System.out.println("다크 점수가 아닙니다");
						return;
					}
				}
        	 }else if(step == 2) {
        		 if("S".equals(target)) {
        			 score[scorePos] = (int)Math.pow(score[scorePos], 1);
        		 }
        		 else if("D".equals(target)) {
        			 score[scorePos] = (int)Math.pow(score[scorePos], 2);
        		 }else if("T".equals(target)) {
        			 score[scorePos] = (int)Math.pow(score[scorePos], 3);
        		 }else if("0".equals(target)) {
        		      if(score[scorePos] == 1) {
        		    	  score[scorePos] = 10;
        	       		     scorePos--;
                     		 step++;
        		      }
        		 }else{
						System.out.println("다크 점수가 아닙니다");
						return;
				}
        		 scorePos++;
        		 step--;
        	 }
        	 lenPos++;
         }
         System.out.println(score[0] + score[1] + score[2]);
	}

}
