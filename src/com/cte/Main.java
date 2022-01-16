package com.cte;

import com.cte.controller.RobotController;
import com.cte.model.Robot;
import com.cte.view.RobotView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sel = 666;
        Scanner userSel = new Scanner(System.in);

        //Initiate the robot
        Robot robot  = new Robot();
        //Initiate the view
        RobotView robotView = new RobotView();
        //Setup the controller
        RobotController controller = new RobotController(robot, robotView);

        //simple UI to test the app
        while(true)
        {
            System.out.println(" |**********************| ");
            System.out.println(" |****     MENU     ****| ");
            System.out.println(" |**********************| ");
            System.out.println(" 1. Move robot ");
            System.out.println(" 100. Exit ");

            //make sure the input is correct
            try {
                sel = userSel.nextInt();
            } catch (Exception e) {
                System.out.println("bad input");
                userSel.next();
            }

            //exit the app
            if(sel == 100) break;


            //select what action to do
            switch (sel) {
                //
                case 0 -> {
                    System.out.println("---");
                }

                case 1 -> {
                    System.out.print("Width(x) of grid: ");
                    int sizeX = userSel.nextInt();
                    controller.setSizeX(sizeX);

                    System.out.print("Depth(y) of grid: ");
                    int sizeY = userSel.nextInt();
                    controller.setSizeY(sizeY);

                    System.out.print("Robot starting position x: ");
                    int startX = userSel.nextInt();
                    controller.setRobotPosX(startX);

                    System.out.print("Robot starting position y: ");
                    int startY = userSel.nextInt();
                    controller.setRobotPosY(startY);

                    System.out.print("Robot starting direction: ");
                    String startDir = userSel.next();
                    controller.setRobotDir(startDir);

                    System.out.print("Robot movement pattern: ");
                    String movementPattern = userSel.next();
                    controller.updatePosition(movementPattern);

                    System.out.println("Result: ");
                    controller.updateView();
                }

                default -> System.out.println("0");
            }
        }



    }
}
