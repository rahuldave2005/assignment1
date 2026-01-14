package com.tss.assignment1;

import java.util.Scanner;

public class SmartCityUtilitySystem {
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            System.out.println();
            System.out.println("Welcome to Smart City Utility System !!");
            System.out.println("Enter a number for menu:");
            System.out.println("1. Electricity Service");
            System.out.println("2. Water Service");
            System.out.println("3. Internet Service");
            System.out.println("4. Exit");

            int choosenNumber=scanner.nextInt();
            boolean exit=false;

            switch (choosenNumber){
                case 1:{
                    electricityService();
                    break;
                }
                case 2:{
                    waterService();
                    break;
                }
                case 3:{
                    internetService();
                    break;
                }
                case 4:{
                    System.out.println("Thank You!! Have a Good Day");
                    exit=true;
                    break;
                }
                default:{
                    System.out.println("Please Enter a Valid Input");
                }
            }
            if(exit)break;
        }

    }

    private static void internetService() {
        System.out.println();
        System.out.println("You have chosen Internet Service");
        System.out.println("Enter a number for sub-menu:");
        System.out.println("1. Student Plan");
        System.out.println("2. Home Plan");
        System.out.println("3. Business Plan");
        System.out.println("4. Back");

        int internetChoosenNumber=scanner.nextInt();
        if(internetChoosenNumber==4)return;
        System.out.println("Enter Duration in months (1/3/6): ");
        int monthDuration=scanner.nextInt();
        if(!(monthDuration==1 || monthDuration==3 || monthDuration==6)){
            System.out.println("Enter a valid duration !!");
            internetService();
            return;
        }

        double totalBill=0;
        switch (internetChoosenNumber){
            case 1:{
                switch (monthDuration){
                    case 1:{
                        totalBill+=299;
                        break;
                    }
                    case 3:{
                        totalBill+=799;
                        break;
                    }
                    case 6:{
                        totalBill+=1499;
                        break;
                    }
                }
                break;
            }
            case 2:{
                switch (monthDuration){
                    case 1:{
                        totalBill+=499;
                        break;
                    }
                    case 3:{
                        totalBill+=1399;
                        break;
                    }
                    case 6:{
                        totalBill+=2699;
                        break;
                    }
                }
                break;
            }
            case 3:{
                switch (monthDuration){
                    case 1:{
                        totalBill+=999;
                        break;
                    }
                    case 3:{
                        totalBill+=2799;
                        break;
                    }
                    case 6:{
                        totalBill+=5499;
                        break;
                    }
                }
                break;
            }
            default:{
                System.out.println("Enter a Valid Input!! ");
                internetService();
            }
        }
        if(monthDuration==6){
            double discount=totalBill*0.05;
            totalBill-=discount;
        }
        System.out.println("Your Internet Bill is: "+totalBill);
        System.out.println();
    }

    private static void waterService() {
        System.out.println();
        System.out.println("You have chosen Water Service");
        System.out.println("Enter a number for sub-menu:");
        System.out.println("1. Residential");
        System.out.println("2. Society");
        System.out.println("3. Factory");
        System.out.println("4. Back");

        int waterChoosenNumber=scanner.nextInt();
        if(waterChoosenNumber==4)return;
        boolean invalidInput=false;

        double totalBill=0;
        switch (waterChoosenNumber){
            case 1:{
                System.out.print("Enter number of persons: ");
                int numberOfPerson=scanner.nextInt();
                if(numberOfPerson<0) {
                    invalidInput=true;
                    System.out.println("Enter persons in positive");
                    waterService();
                    break;
                }
                totalBill+=(30*numberOfPerson);
                break;
            }
            case 2:{
                System.out.print("Enter number of taps: ");
                int numberOfTaps=scanner.nextInt();
                if(numberOfTaps<0) {
                    invalidInput=true;
                    System.out.println("Enter taps in positive");
                    waterService();
                    break;
                }
                totalBill+=(25*numberOfTaps);
                break;
            }
            case 3:{
                System.out.print("Enter number of machines: ");
                int numberOfMachines=scanner.nextInt();
                if(numberOfMachines<0) {
                    invalidInput=true;
                    System.out.println("Enter machines in positive");
                    waterService();
                    break;
                }
                totalBill+=(100*numberOfMachines);
                break;
            }
            case 4:{
                break;
            }
            default:{
                invalidInput=true;
                System.out.println("Enter a valid input !!");
                waterService();
            }
        }

        if(totalBill>3000){
            double tax=totalBill*0.08;
            totalBill+=tax;
        }
        if(!invalidInput){
            System.out.println("Your Total Water Bill is: "+totalBill);
        }

    }

    private static void electricityService(){
        System.out.println();
        System.out.println("You have chosen Electricity Service");
        System.out.println("Enter a number for sub-menu:");
        System.out.println("1. Domestic Collection");
        System.out.println("2. Commercial Collection");
        System.out.println("3. Industrial Collection");
        System.out.println("4. Back");

        int elecChoosenNumber=scanner.nextInt();
        boolean invalidInput=true;
        if(elecChoosenNumber==1 || elecChoosenNumber==2 || elecChoosenNumber==3 || elecChoosenNumber==4 ){
            invalidInput=false;
        }

        double unitsConsumed=0;
        double energyCharge=0;
        double fixedCharge=0;
        double extraAmount=0;
        double totalBill=0;
        boolean unitsChecker=false;

        switch (elecChoosenNumber){
            case 1:{
                System.out.println("Enter Units Consumed: ");
                unitsConsumed=scanner.nextInt();
                if(unitsConsumed<0){
                    unitsChecker=true;
                }

                double bill=0;
                if(unitsConsumed>=0 && unitsConsumed<=100)energyCharge+=2*unitsConsumed;
                else if(unitsConsumed>=101 && unitsConsumed<=300)energyCharge+=3*unitsConsumed;
                else if(unitsConsumed>=301)energyCharge+=5*unitsConsumed;

                fixedCharge=50;
                bill=fixedCharge+energyCharge;

                if(bill>2000) {
                    extraAmount=0.1*bill;
                    bill += extraAmount;
                }

                totalBill=bill;
//                System.out.println("Connection type: Domestic Collection");
                break;
            }
            case 2:{
                System.out.println("Enter Units Consumed: ");
                unitsConsumed=scanner.nextInt();
                if(unitsConsumed<0){
                    unitsChecker=true;
                }

                double bill=0;
                if(unitsConsumed>=0 && unitsConsumed<=200)energyCharge+=5*unitsConsumed;
                else if(unitsConsumed>=201 && unitsConsumed<=500)energyCharge+=7*unitsConsumed;
                else if(unitsConsumed>=501)energyCharge+=10*unitsConsumed;

                fixedCharge=150;
                bill=fixedCharge+energyCharge;

                totalBill=bill;
//                System.out.println("Connection type: Commercial Collection");
                break;
            }
            case 3:{
                System.out.println("Enter Units Consumed: ");
                unitsConsumed=scanner.nextInt();
                if(unitsConsumed<0){
                    unitsChecker=true;
                }

                double bill=0;
                bill+=12*unitsConsumed;
                fixedCharge=500;

                if(unitsConsumed>1000){
                    extraAmount=0.15*bill;
                    bill-=extraAmount;
                }
                totalBill=bill;
//                System.out.println("Connection type: Industrial Collection");
                break;
            }
            default:{
                System.out.println("Enter a valid input !!");
                electricityService();
            }
        }
        if(unitsChecker){
            System.out.println("Please Enter Positive Units");
            electricityService();
            return;
        }
        if(!invalidInput){
            if(elecChoosenNumber==1){
                System.out.println("Connection Type: Domestic Connection");
            }
            else if(elecChoosenNumber==2){
                System.out.println("Connection Type: Commercial Connection");
            }
            else if(elecChoosenNumber==3){
                System.out.println("Connection Type: Industrial Connection");
            }
            System.out.println("Units Consumed: "+unitsConsumed);
            System.out.println("Energy Charge: "+energyCharge);
            System.out.println("Fixed Charge: "+fixedCharge);
            System.out.println("Extra/Rebate: "+extraAmount);
            System.out.println("Total Bill: "+totalBill);

        }
    }

}
