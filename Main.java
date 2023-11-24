import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //DB

        // list of require credits
        String[] engCredits = {"ENG1L", "ENL1W", "ESLAO","ESLBO","ESLCO","ESLDO","ESLEO", "ENG2D", "ENG2L", "ENG3U", "ENG3C", "ENG3E", "ENG4U", "ENG4C", "ENG4E"};

        String[] mathCredits = {"MCR3U", "MCF3M", "MBF3C", "MEL3E", "MAP4C", "MCV4U", "MDM4U", "MHF4U", "MAT1L", "MTH1W", "MPM2D"};
        String[] sciCredits = {"SBI3U","SBI3C", "SCH3U","SBI4U", "SCH3U1", "SCH4U", "SNC1W", "SNC2D", "SNC2L", "SNC2D", "SNC2L"};
        String[] freCredits = {"FSF1D","FSF1O"};
        String[] artCredits = {"ADA1O", "AMI1O", "AMI1O", "AMV1O", "AMR1O", "AVI1O"};
        String[] hisCredits = {"CHC2D"};
        String[] geoCredits = {"CGC1D"};


        // list of university-required course with prerequisites
        String[] mcv4u = {"MTH1W", "MPM2D", "MCR3U", "MCT4C", "MHF4U", "MCV4U"};
        String[] mhf4u = {"MTH1W", "MPM2D", "MCR3U", "MCT4C", "MHF4U"};
        String[] eng4u ={"ENG1D", "ENG2D/ESLEO", "NBE3U/ENG3U", "ENG4U"};
        String[] sbi4u = {"SNC1D", "SNC2D", "SBI3U", "SBI4U1"};
        String[] sch4u = {"SNC1D", "SNC2D", "SCH3U", "SCH4U"};
        String[] sph4u ={"SNC1D", "SNC2D", "SPH3U", "SPH4U"};
        String[] ics4u = {"ICS2O", "ICS3U", "ICS4U"};

        // array list to store the owned credits 
        ArrayList<String> ownedCredits = new ArrayList<String>();

        //User input the credits they have owned
        System.out.println("Enter all the credits CODE you owned (Enter X if you are done): ");    
        String input = sc.nextLine();
        while (!input.equals("X")) {
            if(input.equals("X")){
                break;
            }
            else {
            ownedCredits.add(input);
            input = sc.nextLine();
            }
        }

        //Check student can graduate or not
        int noEngCredits = 0;
        int noMathCredits = 0;
        int noSciCredits = 0;
        int noHistoryCredits = 0;
        int noGeoCredits = 0;
        int noArtCredits = 0;
        int noPECredits = 0;
        int noFrenchCredits = 0;
        int noCareerCredits = 0;

        // count number of credits by match the first letter
        for (String code : ownedCredits) {
            if (code.charAt(0)=='E'){
                noEngCredits++;
            }
            else if(code.charAt(0)=='M'){
                noMathCredits++;
            }
            else if(code.charAt(0)=='S'){
                noSciCredits++;
            }
            else if(code.charAt(0)=='C'&& code.charAt(1) =='H'){
                noHistoryCredits ++;
            }
            else if(code.charAt(0)=='C' && code.charAt(1)=='G'){
                noGeoCredits++;
            }
            else if(code.charAt(0)=='A'){
                noArtCredits++;
            }
            else if(code.charAt(0)=='P'){
                noPECredits++;
            }
            else if(code.charAt(0)=='F'){
                noFrenchCredits++;
            }
            else if(code.charAt(0)=='C' && code.charAt(1)=='I'){
                noCareerCredits++;
            }
             
        }
        int missing = 0;
        String level = "";

        // finding what credits are missing and then print out the credits they should take next
        
        // missing eng credits
        if (noEngCredits < 4) {
            missing = 4 - noEngCredits;
            level = Integer.toString(noEngCredits + 1); 
            System.out.println("You need " + missing + " more English credits. Courses you can choose: ");

            for (String engCredit: engCredits) {
                if (engCredit.contains("ESL") || engCredit.contains(level)) {
                    System.out.println(engCredit);
                }
            }
        }
        
        
        // missing math credits
        if (noMathCredits < 3) {
            missing = 3 - noMathCredits;
            level = Integer.toString(noMathCredits + 1);
            System.out.println("You need " + missing + " more Math credits. Courses you can choose: ");

            for (String mathCredit : mathCredits) {
                if (mathCredit.contains(level)) {
                    System.out.println(mathCredit);
                }
            }
        }

        // missing sci credit
        if (noSciCredits < 2) {
            missing = 2 - noSciCredits;
            level = Integer.toString(noSciCredits + 1);
            System.out.println("You need " + missing + " more Science credits. Courses you can choose: ");

            for (String sciCredit : sciCredits) {
                if (sciCredit.contains(level)) {
                    System.out.println(sciCredit);
                }
            } 
        }

        // missing history credit
        if (noHistoryCredits < 1) {
            System.out.println("You need 1 more History credits. Courses you can choose: ");
            System.out.println("CHC2D");
        }

        // misisng geopgrahy credit
        if (noGeoCredits < 1){
            System.out.println("You need 1 more Geography Credits. Courses you can choose: ");
            System.out.println("CGC1D");
        }

        // missing art credit
        if(noArtCredits<1){
            System.out.println("You need 1 more Art Credits. Courses you can choose: ");
            for (String artCredit : artCredits) {
                System.out.println(artCredit);
            }
        }

        // missing pe credit
        if (noPECredits < 1){
            System.out.println("You need 1 more PE Credits. Courses you can choose: ");
            System.out.println("PPL1O");
        }

        // missing french credit
        if (noFrenchCredits < 1){
            System.out.println("you need 1 more French Credits");
            for (String freCredit: freCredits) {
                System.out.println(freCredit);
            }
        }

        //missing career credit
        if (noCareerCredits < 1){
          System.out.println("You need 1 more Career and Civics Credits. Courses you can choose: ");
          System.out.println("CCR1O");
        }


        // second part
        System.out.println("Enter the require courses for your university pathway: (enter X if you are done) ");
        input = sc.nextLine();
        while (!(input.equals("X"))) {

            // courses require for calcus and vector
            if (input.equals("MCV4U")) {
                System.out.println("You will need these course(s) in order");
                for (String code: mcv4u) {
                    if (!ownedCredits.contains(code)) {
                        System.out.print(code);
                        System.out.print(" -> ");
                    }   
                }
                System.out.println("");
            }

            // courses require for function
            else if (input.equals("MHF4U")) {
                System.out.println("You will need these course(s) in order");
                for (String code: mhf4u) {
                    if (!ownedCredits.contains(code)) {
                        System.out.print(code);
                        System.out.print(" -> ");
                    }    
                }
                System.out.println("");
            }

            // courses require for english grade 12
            else if (input.equals("ENG4U")) {
                System.out.println("You will need these course(s) in order");
                for (String code: eng4u) {
                    if (!ownedCredits.contains(code)) {
                        System.out.print(code);
                        System.out.print(" -> ");
                    }   
                }
                System.out.println("");
            }

            // courses require for physic 12
            else if (input.equals("SPH4U")) {
                System.out.println("You will need these course(s) in order");
                for (String code: sph4u) {             
                    if (!ownedCredits.contains(code)) {
                        System.out.print(code);
                        System.out.print(" -> ");
                    }  
                }
                System.out.println("");
            }

            // courses require for biology 12
            else if (input.equals("SBI4U")) {
                System.out.println("You will need these course(s) in order");
                for (String code: sbi4u) {
                    if (!ownedCredits.contains(code)) {
                        System.out.print(code);
                        System.out.print(" -> ");;
                    }   
                }
                System.out.println("");
            }

            // courses require for chemistry 12
            else if (input.equals("SCH4U")) {
                System.out.println("You will need these course(s) in order");
                for (String code: sch4u) {
                    if (!ownedCredits.contains(code)) {
                        System.out.print(code);
                        System.out.print(" -> ");
                    }   
                }
                System.out.println("");
            }
            else if (input.equals("ICS4U")) {
              System.out.println("You will need these course(s) in order");
              for (String code: ics4u) {
                  if (!ownedCredits.contains(code)) {
                      System.out.print(code);
                      System.out.print(" -> ");
                  }   
              }
              System.out.println("");
          }
            input = sc.nextLine();
        }
        
        sc.close();
        
    }
}